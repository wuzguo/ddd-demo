package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.metrics.techinfluence.ATAMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.ATAMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.InfluenceMetric;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.ATAMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * ATAMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:42 AM
 */

@Component
public class ATAMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(ATAMetricAddCmd cmd) {
        ATAMetricItem ataMetricItem = new ATAMetricItem();
        BeanUtils.copyProperties(cmd.getAtaMetric(), ataMetricItem);
        ataMetricItem.setSubMetric(
            new ATAMetric(new InfluenceMetric(new UserProfile(cmd.getAtaMetric().getOwnerId()))));
        metricTunnel.save(ataMetricItem);
        return Response.buildSuccess();
    }
}
