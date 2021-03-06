package com.archforce.demo.ddd.domain.metrics.appquality;

import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

public class AppMetric extends SubMetric {

    public AppMetric() {
        this.subMetricType = SubMetricTypeEnum.APP;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }

    @Override
    public double calculateScore() {
        int appCount = super.getMetricItems().size();
        if (appCount == 0) {
            return 0;
        }
        double sumScore = super.calculateScore();
        return sumScore / appCount;
    }
}