package com.archforce.demo.ddd.domain.user;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.Assert;
import com.archforce.demo.ddd.domain.enums.RoleEnum;
import com.archforce.demo.ddd.domain.metrics.appquality.AppQualityMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.DevQualityMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.ContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.InfluenceMetric;
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

    private String id;

    private String userId;

    private String userName;

    private String dep;

    private RoleEnum role;

    private String isManager;

    private Weight weight;

    private double totalScore;

    private double appQualityScore;

    private double techInfluenceScore;

    private double techContributionScore;

    private double devQualityScore;

    private double checkinCodeQuantity;

    private AppQualityMetric appQualityMetric;

    private InfluenceMetric influenceMetric;

    private ContributionMetric contributionMetric;

    private DevQualityMetric devQualityMetric;

    private static double MAX_IMUM_SCORE = 100;

    private static double MIN_IMUM_SCORE = 0;

    public void calculateScore() {
        calculateTechInfluenceScore();
        calculateTechContributionScore();
        calculateDevQualityMetric();
        calculateAppQualityMetric();
        calculateTotalScore();
    }

    private void calculateAppQualityMetric() {
        Assert.notNull(appQualityMetric, "appQualityMetric is null, initialize it before calculating");
        appQualityScore = appQualityMetric.calculateScore();
    }

    private void calculateDevQualityMetric() {
        Assert.notNull(devQualityMetric, "devQualityMetric is null, initialize it before calculating");
        devQualityScore = devQualityMetric.calculateScore();
    }

    private void calculateTechInfluenceScore() {
        Assert.notNull(influenceMetric, "influenceMetric is null, initialize it before calculating");
        techInfluenceScore = influenceMetric.calculateScore();
    }

    private void calculateTechContributionScore() {
        Assert.notNull(contributionMetric, "contributionMetric is null, initialize it before calculating");
        techContributionScore = contributionMetric.calculateScore();
    }

    private void calculateTotalScore() {
        totalScore = round(this.techInfluenceScore) * influenceMetric.getWeight()
            + round(this.techContributionScore) * contributionMetric.getWeight()
            + round(this.devQualityScore) * devQualityMetric.getWeight()
            + round(this.appQualityScore) * appQualityMetric.getWeight();
    }

    private double round(double score) {
        if (score > MAX_IMUM_SCORE) {
            score = MAX_IMUM_SCORE;
        } else if (score < MIN_IMUM_SCORE) {
            score = MIN_IMUM_SCORE;
        }
        return score;
    }

    public UserProfile(String userId) {
        this.userId = userId;
    }
}
