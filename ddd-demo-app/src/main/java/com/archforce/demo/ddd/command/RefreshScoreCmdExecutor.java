package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.Assert;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.tunnel.UserProfileTunnel;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.appquality.AppMetric;
import com.archforce.demo.ddd.domain.metrics.appquality.AppQualityMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.BugMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.DevQualityMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.ContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.InfluenceMetric;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.RefreshScoreCmd;
import com.archforce.demo.ddd.event.handler.MetricItemCreatedHandler;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class RefreshScoreCmdExecutor {

    private Logger logger = LoggerFactory.getLogger(MetricItemCreatedHandler.class);

    @Resource
    private UserProfileTunnel userProfileTunnel;

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(RefreshScoreCmd cmd) {
        UserProfile userProfile = getUserProfile(cmd);
        calculateScore(userProfile);
        update(userProfile);
        return Response.buildSuccess();
    }

    private UserProfile getUserProfile(RefreshScoreCmd cmd) {
        UserProfile userProfile = userProfileTunnel.getByUserId(cmd.getUserId());
        Assert.notNull(userProfile, "There is no User Profile for " + cmd.getUserId() + " to update");
        return userProfile;
    }

    private void calculateScore(UserProfile userProfile) {
        loadInfluenceMetric(userProfile);
        loadContributionMetrics(userProfile);
        loadDevQualityMetrics(userProfile);
        loadAppQualityMetrics(userProfile);
        userProfile.calculateScore();
    }

    private void loadAppQualityMetrics(UserProfile userProfile) {
        AppQualityMetric appQualityMetric = new AppQualityMetric(userProfile);
        AppMetric appMetric = metricTunnel.getAppMetric(userProfile.getUserId());
        appMetric.setParent(appQualityMetric);
    }

    private void loadDevQualityMetrics(UserProfile userProfile) {
        DevQualityMetric devQualityMetric = new DevQualityMetric(userProfile);
        BugMetric bugMetric = metricTunnel.getBugMetric(userProfile.getUserId());
        bugMetric.setParent(devQualityMetric);
    }

    private void loadContributionMetrics(UserProfile userProfile) {
        ContributionMetric contributionMetric = new ContributionMetric(userProfile);
        List<SubMetric> subMetricList = metricTunnel.listByTechContribution(userProfile.getUserId());
        subMetricList.forEach(subMetric -> subMetric.setParent(contributionMetric));
    }

    private void loadInfluenceMetric(UserProfile userProfile) {
        InfluenceMetric influenceMetric = new InfluenceMetric(userProfile);
        List<SubMetric> subMetricList = metricTunnel.listByTechInfluence(userProfile.getUserId());
        subMetricList.forEach(subMetric -> subMetric.setParent(influenceMetric));
    }

    private void update(UserProfile userProfile) {
        userProfileTunnel.update(userProfile);
    }
}
