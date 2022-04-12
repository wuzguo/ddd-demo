package com.archforce.demo.ddd.domain.metrics.devquality;

import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricType;
import com.archforce.demo.ddd.domain.user.Role;


/**
 * BUG数指标
 */
public class BugMetric extends SubMetric {

    public BugMetric() {
        this.subMetricType = SubMetricType.Bug;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }

    @Override
    public double calculateScore() {
        if (metricOwner.getRole() == Role.OTHER) {
            return 0;
        }
        return super.calculateScore();
    }
}
