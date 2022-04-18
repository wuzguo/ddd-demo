package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.MainMetricType;
import com.archforce.demo.ddd.domain.user.UserProfile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InfluenceMetric 影响力指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:24 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TechInfluenceMetric extends MainMetric {

    private ATAMetric ataMetric;

    private PatentMetric patentMetric;

    private SharingMetric sharingMetric;

    private PaperMetric paperMetric;

    public TechInfluenceMetric(UserProfile metricOwner) {
        this.metricOwner = metricOwner;
        metricOwner.setInfluenceMetric(this);
        this.metricMainType = MainMetricType.TECH_INFLUENCE;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getTechInfluenceWeight();
    }
}
