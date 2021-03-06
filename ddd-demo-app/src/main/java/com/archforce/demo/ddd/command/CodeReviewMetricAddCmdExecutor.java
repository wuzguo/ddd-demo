package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.metrics.techcontribution.CodeReviewMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.CodeReviewMetricItem;
import com.archforce.demo.ddd.domain.metrics.techcontribution.TechContributionMetric;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.CodeReviewMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * CodeReviewMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:14 AM
 */
@Component
public class CodeReviewMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(CodeReviewMetricAddCmd cmd) {
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        BeanUtils.copyProperties(cmd, codeReviewMetricItem);
        codeReviewMetricItem.setSubMetric(
            new CodeReviewMetric(new TechContributionMetric(new UserProfile(cmd.getOwnerId()))));
        metricTunnel.save(codeReviewMetricItem);
        return Response.buildSuccess();
    }
}