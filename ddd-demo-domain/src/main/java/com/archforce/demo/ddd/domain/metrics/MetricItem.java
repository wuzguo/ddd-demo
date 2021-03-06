package com.archforce.demo.ddd.domain.metrics;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.archforce.demo.ddd.domain.user.UserProfile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * MetricItem 指标项，多个指标项可以构成一个指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:23 PM
 */

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MetricItem extends EntityObject implements Measurable {

    /**
     * The metric this MetricItem belongs to
     */
    @JSONField(serialize = false)
    private SubMetric subMetric;

    /**
     * The owner of this MetricItem
     */
    @JSONField(serialize = false)
    private UserProfile metricOwner;

    public void setSubMetric(SubMetric subMetric) {
        this.subMetric = subMetric;
        this.metricOwner = subMetric.getMetricOwner();
    }

    /**
     * 将度量项的转成JSON
     *
     * @return {@link String}
     */
    public String toJsonString() {
        String jsonStr = JSON.toJSONString(this);
        log.debug("\n From : " + this + " \n To: " + jsonStr);
        return jsonStr;
    }

}
