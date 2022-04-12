package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.metrics.techcontribution.ContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.RefactoringLevel;
import com.archforce.demo.ddd.domain.metrics.techcontribution.RefactoringMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.RefactoringMetricItem;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.RefactoringMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * RefactoringMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class RefactoringMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(RefactoringMetricAddCmd cmd) {
        RefactoringMetricItem refactoringMetricItem = new RefactoringMetricItem();
        BeanUtils.copyProperties(cmd.getRefactoringMetricCO(), refactoringMetricItem);
        refactoringMetricItem.setSubMetric(
            new RefactoringMetric(new ContributionMetric(new UserProfile(cmd.getRefactoringMetricCO().getOwnerId()))));
        refactoringMetricItem.setRefactoringLevel(
            RefactoringLevel.valueOf(cmd.getRefactoringMetricCO().getRefactoringLevel()));
        metricTunnel.save(refactoringMetricItem);
        return Response.buildSuccess();
    }
}
