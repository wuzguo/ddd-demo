package com.archforce.demo.ddd.domain.tunnel;

import com.archforce.demo.ddd.domain.metrics.MetricItem;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.appquality.AppMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.BugMetric;
import java.util.List;

/**
 * MetricGateway
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:16 PM
 */
public interface MetricTunnel {

    void save(MetricItem metricItem);

    List<SubMetric> listByTechContribution(String userId);

    List<SubMetric> listByTechInfluence(String userId);

    BugMetric getBugMetric(String userId);

    AppMetric getAppMetric(String userId);
}
