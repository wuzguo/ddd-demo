package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.SubMetricTypeEnum;

/**
 * 论文子度量 PaperMetric
 *
 * @author Frank Zhang
 * @date 2018-09-20 3:26 PM
 */
public class PaperMetric extends SubMetric {

    public PaperMetric() {
        this.subMetricType = SubMetricTypeEnum.PAPER;
    }

    public PaperMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricTypeEnum.PAPER;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
