package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.domain.tunnel.MetricTunnel;
import com.archforce.demo.ddd.domain.metrics.techinfluence.AuthorType;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PatentMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PatentMetricItem;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.PatentMetricAddCmd;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExecutor {

    @Resource
    private MetricTunnel metricTunnel;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetric(), patentMetricItem);
        patentMetricItem.setSubMetric(
            new PatentMetric(new TechInfluenceMetric(new UserProfile(cmd.getPatentMetric().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetric().getAuthorType()));
        metricTunnel.save(patentMetricItem);
        return Response.buildSuccess();
    }
}