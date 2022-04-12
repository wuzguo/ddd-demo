package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.MetricItem;
import java.util.Date;
import lombok.Data;

/**
 * SharingMetricItem 技术线下分享指标项
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:20 PM
 */
@Data
public class SharingMetricItem extends MetricItem {

    private static Logger logger = LoggerFactory.getLogger(SharingMetricItem.class);

    private String sharingName;
    private SharingScope sharingScope;
    private Date sharingDate;
    private String sharingLink;

    public SharingMetricItem() {

    }

    public SharingMetricItem(String sharingName, SharingScope sharingScope, Date sharingDate, String url) {
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
