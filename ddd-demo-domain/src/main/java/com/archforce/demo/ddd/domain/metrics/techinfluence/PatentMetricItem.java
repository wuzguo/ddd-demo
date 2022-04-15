package com.archforce.demo.ddd.domain.metrics.techinfluence;

import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.MetricItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 技术创新指标项
 *
 * @author xueliang.sxl
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PatentMetricItem extends MetricItem {

    private String patentName;

    private String patentDesc;

    private String patentNo;

    private String patentUrl;

    private AuthorType authorType;

    public PatentMetricItem() {

    }

    public PatentMetricItem(String patentName, String patentDesc, String patentNo, String patentUrl,
        AuthorType authorType) {
        this.patentName = patentName;
        this.patentDesc = patentDesc;
        this.patentNo = patentNo;
        this.patentUrl = patentUrl;
        this.authorType = authorType;
    }

    public static PatentMetricItem valueOf(String json) {
        return JSON.parseObject(json, PatentMetricItem.class);
    }

    @Override
    public double calculateScore() {
        return authorType.getScore();
    }

}
