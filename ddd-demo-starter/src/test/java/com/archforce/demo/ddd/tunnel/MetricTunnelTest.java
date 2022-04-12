package com.archforce.demo.ddd.tunnel;

import com.archforce.demo.ddd.domain.metrics.MainMetricType;
import com.archforce.demo.ddd.domain.metrics.SubMetricType;
import com.archforce.demo.ddd.tunnel.database.MetricMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.MetricDO;
import java.util.List;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is Tunnel Test, no need to mock, and no regression needed as well
 *
 * @author Frank Zhang
 * @date 2019-02-27 2:33 PM
 */
public class MetricTunnelTest {

    @Resource
    private MetricMapper metricMapper;

    public void testCRUD() {
        String userId = "MetricTunnelTest" + Math.random();
        MetricDO metricDO = new MetricDO();
        metricDO.setMainMetric(MainMetricType.TECH_INFLUENCE.getMetricCode());
        metricDO.setSubMetric(SubMetricType.Refactoring.getMetricSubTypeCode());
        metricDO.setUserId(userId);
        metricDO.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");

        metricMapper.create(metricDO);

        List<MetricDO> metricDOS = metricMapper.listByUserId(userId);
        Assert.assertEquals(1, metricDOS.size());

        metricMapper.delete(metricDOS.get(0).getId(), "MetricTunnelTest");
        Assert.assertEquals(0, metricMapper.listByUserId(userId).size());
    }
}
