package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.dto.MetricDeleteCmd;
import com.archforce.demo.ddd.gatewayimpl.database.MetricMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * MetricDeleteCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 3:01 PM
 */
@Component
public class MetricDeleteCmdExe {

    @Resource
    private MetricMapper metricMapper;

    public Response execute(MetricDeleteCmd cmd) {

        metricMapper.delete(cmd.getMetricId(), cmd.getOperater());
        return Response.buildSuccess();
    }
}