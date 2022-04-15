package com.archforce.demo.ddd.domain.metrics.techcontribution;

import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.MetricItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设计指标度量项
 *
 * @author zak
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MiscMetricItem extends MetricItem {

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 文档链接
     */
    private String docUrl;

    /**
     * 代码链接
     */
    private String codeUrl;


    private static final double OUTSTANDING_CONTRIBUTION_SCORE = 20;

    public MiscMetricItem() {

    }

    public MiscMetricItem(String name, String content, String docUrl, String codeUrl) {
        this.name = name;
        this.codeUrl = codeUrl;
        this.content = content;
        this.docUrl = docUrl;
    }


    public static MiscMetricItem valueOf(String json) {
        return JSON.parseObject(json, MiscMetricItem.class);
    }

    /**
     * 计算当前度量项分数
     *
     * @return 分数
     */
    @Override
    public double calculateScore() {
        return OUTSTANDING_CONTRIBUTION_SCORE;
    }
}
