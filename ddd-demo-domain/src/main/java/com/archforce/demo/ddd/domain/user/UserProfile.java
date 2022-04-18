package com.archforce.demo.ddd.domain.user;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.Assert;
import com.archforce.demo.ddd.domain.enums.RoleEnum;
import com.archforce.demo.ddd.domain.metrics.appquality.AppQualityMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.DevQualityMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.TechContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.weight.Weight;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 员工档案
 *
 * @author frankzhang
 */

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserProfile extends EntityObject {

    /**
     * ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 部门
     */
    private String dep;

    /**
     * 角色
     */
    private RoleEnum role;

    /**
     * 是否管理员
     */
    private String isManager;

    /**
     * 权重值
     */
    private Weight weight;

    /**
     * 总分
     */
    private double totalScore;

    /**
     * APP质量分
     */
    private double appQualityScore;

    /**
     * 技术影响力分
     */
    private double techInfluenceScore;

    /**
     * 技术贡献度分
     */
    private double techContributionScore;

    /**
     * 开发质量分
     */
    private double devQualityScore;

    /**
     * 代码审查分
     */
    private double codeReviewQuantity;

    /**
     * APP质量指标
     */
    private AppQualityMetric appQualityMetric;

    /**
     * 影响力指标
     */
    private TechInfluenceMetric influenceMetric;

    /**
     * 贡献度指标
     */
    private TechContributionMetric contributionMetric;

    /**
     * 开发质量指标
     */
    private DevQualityMetric devQualityMetric;

    /**
     * 最大值
     */
    private static final double MAX_MUM_SCORE = 100;

    /**
     * 最小值
     */
    private static final double MIN_MUM_SCORE = 0;

    public UserProfile(String userId) {
        this.userId = userId;
    }

    /**
     * 计算分数
     */
    public void calculateScore() {
        // 影响力
        calcTechInfluenceScore();
        // 贡献度
        calcTechContributionScore();
        // 开发质量
        calcDevQualityMetric();
        // APP质量
        calcAppQualityMetric();
        // 总分
        calcTotalScore();
    }

    private void calcAppQualityMetric() {
        Assert.notNull(appQualityMetric, "appQualityMetric is null, initialize it before calculating");
        appQualityScore = appQualityMetric.calculateScore();
    }

    private void calcDevQualityMetric() {
        Assert.notNull(devQualityMetric, "devQualityMetric is null, initialize it before calculating");
        devQualityScore = devQualityMetric.calculateScore();
    }

    private void calcTechInfluenceScore() {
        Assert.notNull(influenceMetric, "influenceMetric is null, initialize it before calculating");
        techInfluenceScore = influenceMetric.calculateScore();
    }

    private void calcTechContributionScore() {
        Assert.notNull(contributionMetric, "contributionMetric is null, initialize it before calculating");
        techContributionScore = contributionMetric.calculateScore();
    }

    private void calcTotalScore() {
        totalScore = round(this.techInfluenceScore) * influenceMetric.getWeight()
            + round(this.techContributionScore) * contributionMetric.getWeight()
            + round(this.devQualityScore) * devQualityMetric.getWeight()
            + round(this.appQualityScore) * appQualityMetric.getWeight();
    }

    private double round(double score) {
        if (score > MAX_MUM_SCORE) {
            score = MAX_MUM_SCORE;
        } else if (score < MIN_MUM_SCORE) {
            score = MIN_MUM_SCORE;
        }
        return score;
    }
}
