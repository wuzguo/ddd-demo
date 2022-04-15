package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

/**
 * ATAMetric ATA文章指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:24 PM
 */
public class ATAMetric extends SubMetric {

    public ATAMetric() {
        this.subMetricType = SubMetricTypeEnum.ATA;
    }

    public ATAMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricTypeEnum.ATA;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
