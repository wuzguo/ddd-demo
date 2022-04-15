package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.MetricItem;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * SharingMetricItem 技术线下分享指标项
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:20 PM
 */


@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class SharingMetricItem extends MetricItem {

    private String sharingName;

    private SharingScopeEnum sharingScope;

    private Date sharingDate;

    private String sharingLink;

    public SharingMetricItem() {

    }

    public SharingMetricItem(String sharingName, SharingScopeEnum sharingScope, Date sharingDate, String url) {
        this.sharingName = sharingName;
        this.sharingScope = sharingScope;
        this.sharingDate = sharingDate;
        this.sharingLink = url;
    }

    public static SharingMetricItem valueOf(String json) {
        return JSON.parseObject(json, SharingMetricItem.class);
    }

    @Override
    public double calculateScore() {
        return sharingScope.getScore();
    }

}
