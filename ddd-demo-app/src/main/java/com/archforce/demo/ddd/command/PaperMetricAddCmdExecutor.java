package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PaperMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PaperMetricItem;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.PaperMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * PaperMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PaperMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(PaperMetricAddCmd cmd) {
        PaperMetricItem paperMetricItem = new PaperMetricItem();
        BeanUtils.copyProperties(cmd.getPaperMetric(), paperMetricItem);
        paperMetricItem.setSubMetric(
            new PaperMetric(new TechInfluenceMetric(new UserProfile(cmd.getPaperMetric().getOwnerId()))));
        paperMetricItem.setMetricOwner(new UserProfile(cmd.getPaperMetric().getOwnerId()));
        metricTunnel.save(paperMetricItem);

        return Response.buildSuccess();
    }
}