package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.metrics.techcontribution.ContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.MiscMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.MiscMetricItem;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.MiscMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * MiscMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class MiscMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(MiscMetricAddCmd cmd) {
        MiscMetricItem miscMetricItem = new MiscMetricItem();
        BeanUtils.copyProperties(cmd.getMiscMetricCO(), miscMetricItem);
        miscMetricItem.setSubMetric(
            new MiscMetric(new ContributionMetric(new UserProfile(cmd.getMiscMetricCO().getOwnerId()))));
        metricTunnel.save(miscMetricItem);
        return Response.buildSuccess();
    }
}