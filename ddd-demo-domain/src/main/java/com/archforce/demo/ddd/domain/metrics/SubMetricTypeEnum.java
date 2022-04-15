package com.archforce.demo.ddd.domain.metrics;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SubMetricType
 *
 * @author Frank Zhang
 * @date 2018-08-27 4:54 PM
 */

@Getter
@AllArgsConstructor
public enum SubMetricTypeEnum {

    /**
     * 超长方法
     */
    LONG_METHOD(MainMetricType.APP_QUALITY, "LongMethod", "超长方法"),

    /**
     * 圈复杂度
     */
    CYCLOMATIC(MainMetricType.APP_QUALITY, "Cyclomatic", "圈复杂度"),

    /**
     * 代码重复度
     */
    DUPLICATION(MainMetricType.APP_QUALITY, "Duplication", "代码重复度"),

    /**
     * App应用
     */
    APP(MainMetricType.APP_QUALITY, "App", "App应用"),

    /**
     * ATA文章
     */
    ATA(MainMetricType.TECH_INFLUENCE, "ATA", "ATA文章"),

    /**
     * 技术分享
     */
    SHARING(MainMetricType.TECH_INFLUENCE, "Sharing", "技术分享"),

    /**
     * 专利
     */
    PATENT(MainMetricType.TECH_INFLUENCE, "Patent", "专利"),

    /**
     * 论文
     */
    PAPER(MainMetricType.TECH_INFLUENCE, "Paper", "论文"),

    /**
     * Code Review
     */
    CODE_REVIEW(MainMetricType.TECH_CONTRIBUTION, "CodeReview", "Code Review"),

    /**
     * 重构
     */
    REFACTORING(MainMetricType.TECH_CONTRIBUTION, "Refactoring", "重构"),

    /**
     * 其他贡献
     */
    MISC(MainMetricType.TECH_CONTRIBUTION, "Misc", "其他贡献"),

    /**
     * 提测Bug
     */
    BUG(MainMetricType.DEV_QUALITY, "Bug", "提测Bug"),

    /**
     * 故障
     */
    FAULT(MainMetricType.DEV_QUALITY, "Fault", "故障");

    /**
     * 度量类型
     */
    private final MainMetricType parentType;

    /**
     * 度量项Code
     */
    private final String metricSubTypeCode;

    /**
     * 度量项中文名称
     */
    private final String metricSubTypeName;

}
