package com.archforce.demo.ddd.domain.metrics;

import com.archforce.demo.ddd.domain.user.UserProfile;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Sub Metric,  一个主度量（MainMetric）可以有一个或者多个子度量（SubMetric）组成的。
 *
 * @author Frank Zhang
 * @date 2018-08-27 6:44 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SubMetric extends Metric {

    protected SubMetricTypeEnum subMetricType;

    protected MainMetric parent;

    @Getter
    private List<MetricItem> metricItems = new ArrayList<>();

    public SubMetric() {

    }

    public void setParent(MainMetric parent) {
        this.parent = parent;
        this.metricOwner = parent.metricOwner;
        parent.addSubMetric(this);
    }

    /**
     * 添加度量项
     *
     * @param metricItem {@link MetricItem}
     */
    public void addMetricItem(MetricItem metricItem) {
        metricItems.add(metricItem);
    }


    @Override
    public String getName() {
        return subMetricType.getMetricSubTypeName();
    }

    @Override
    public String getCode() {
        return subMetricType.getMetricSubTypeCode();
    }

    @Override
    public double calculateScore() {
        double subMetricScore = 0;
        for (MetricItem metricItem : metricItems) {
            subMetricScore = subMetricScore + metricItem.calculateScore();
        }
        return subMetricScore;
    }

    @Override
    public UserProfile getMetricOwner() {
        return parent.getMetricOwner();
    }
}
