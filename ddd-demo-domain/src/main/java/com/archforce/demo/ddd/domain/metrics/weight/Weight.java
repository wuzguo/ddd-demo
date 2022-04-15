package com.archforce.demo.ddd.domain.metrics.weight;

/**
 * Weight 权重
 *
 * @author Frank Zhang
 * @date 2018-09-13 12:13 PM
 */
public abstract class Weight {

    public static final double WEIGHT_PERCENTAGE = 100;

    /**
     * 获取APP质量权重
     *
     * @return 权重值
     */
    public abstract double getAppQualityWeight();

    /**
     * 获取技术影响力权重
     *
     * @return 权重值
     */
    public abstract double getTechInfluenceWeight();

    /**
     * 获取技术贡献度权重
     *
     * @return 权重值
     */
    public abstract double getTechContributionWeight();

    /**
     * 获取开发质量权重
     *
     * @return 权重值
     */
    public abstract double getDevQualityWeight();

    /**
     * 获取一致权重
     *
     * @return 权重值
     */
    public double getUnanimousWeight() {
        return 100 / WEIGHT_PERCENTAGE;
    }

}
