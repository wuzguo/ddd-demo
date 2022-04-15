package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

/**
 * SharingMetric 线下技术分享指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:25 PM
 */
public class SharingMetric extends SubMetric {

    public SharingMetric() {
        this.subMetricType = SubMetricTypeEnum.SHARING;
    }

    public SharingMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricTypeEnum.SHARING;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
