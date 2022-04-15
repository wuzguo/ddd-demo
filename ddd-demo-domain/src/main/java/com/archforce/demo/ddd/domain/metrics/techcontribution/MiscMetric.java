package com.archforce.demo.ddd.domain.metrics.techcontribution;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

/**
 * Miscellaneous，其他度量，任何的技术亮点都可以添加
 *
 * @author frankzhang
 */
public class MiscMetric extends SubMetric {

    public MiscMetric() {
        this.subMetricType = SubMetricTypeEnum.MISC;
    }

    public MiscMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricTypeEnum.MISC;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }
}
