package com.archforce.demo.ddd.domain.metrics.appquality;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.MainMetricType;
import com.archforce.demo.ddd.domain.user.UserProfile;

/**
 * @author Zak
 */


public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile userProfile) {
        this.metricOwner = userProfile;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
