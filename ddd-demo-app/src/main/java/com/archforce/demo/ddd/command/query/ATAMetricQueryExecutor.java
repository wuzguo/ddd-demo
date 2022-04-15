package com.archforce.demo.ddd.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;
import com.archforce.demo.ddd.dto.ATAMetricQuery;
import com.archforce.demo.ddd.dto.clientobject.ATAMetricCO;
import com.archforce.demo.ddd.tunnel.database.MetricMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.MetricDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ATAMetricQueryExecutor {

    @Resource
    private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQuery cmd) {
        List<MetricDO> metricDOList = metricMapper.listBySubMetric(cmd.getOwnerId(),
            SubMetricTypeEnum.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(metricDO -> {
            ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
            ataMetricCO.setOwnerId(metricDO.getUserId());
            ataMetricCOList.add(ataMetricCO);
        });
        return MultiResponse.ofWithoutTotal(ataMetricCOList);
    }

}
