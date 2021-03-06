package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingScopeEnum;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.SharingMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * SharingMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-02 5:00 PM
 */
@Component
public class SharingMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(SharingMetricAddCmd cmd) {
        SharingMetricItem sharingMetricItem = new SharingMetricItem();
        BeanUtils.copyProperties(cmd.getSharingMetric(), sharingMetricItem);
        sharingMetricItem.setSubMetric(
            new SharingMetric(new TechInfluenceMetric(new UserProfile(cmd.getSharingMetric().getOwnerId()))));
        sharingMetricItem.setSharingScope(SharingScopeEnum.valueOf(cmd.getSharingMetric().getSharingScope()));
        metricTunnel.save(sharingMetricItem);
        return Response.buildSuccess();
    }
}
