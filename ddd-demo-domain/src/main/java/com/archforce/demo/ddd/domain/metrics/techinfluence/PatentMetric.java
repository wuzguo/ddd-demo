package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

/**
 * 技术专利指标
 *
 * @author xueliang.sxl
 */
public class PatentMetric extends SubMetric {

    public PatentMetric() {
        this.subMetricType = SubMetricTypeEnum.PATENT;
    }

    public PatentMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricTypeEnum.PATENT;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
