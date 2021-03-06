package com.archforce.demo.ddd.domain.metrics;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

/**
 * Main Metric, 一个主度量（MainMetric）是由多个子度量（SubMetric）组成的。
 *
 * @author Frank Zhang
 * @date 2018-08-28 2:00 PM
 */
@Data
public abstract class MainMetric extends Metric {


    protected MainMetricType metricMainType;

    protected List<SubMetric> subMetrics = Lists.newArrayList();

    public MainMetric() {
    }

    public void addSubMetric(SubMetric metric) {
        subMetrics.add(metric);
    }

    @Override
    public String getName() {
        return metricMainType.getName();
    }

    @Override
    public String getCode() {
        return metricMainType.getCode();
    }


    @Override
    public double calculateScore() {
        double mainMetricScore = 0;
        for (Metric subMetric : subMetrics) {
            mainMetricScore = mainMetricScore + subMetric.calculateScore() * subMetric.getWeight();
        }
        return mainMetricScore;
    }
}
