package com.archforce.demo.ddd.domain.metrics.techcontribution;

import com.archforce.demo.ddd.domain.metrics.MainMetric;
import com.archforce.demo.ddd.domain.metrics.MainMetricType;
import com.archforce.demo.ddd.domain.user.UserProfile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * ContributionMetric
 *
 * @author Frank Zhang
 * @date 2018-08-27 7:06 PM
 */

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class TechContributionMetric extends MainMetric {

    private CodeReviewMetric codeReviewMetric;

    private RefactoringMetric refactoringMetric;

    private MiscMetric miscMetric;

    public TechContributionMetric(UserProfile metricOwner) {
        this.metricOwner = metricOwner;
        metricOwner.setContributionMetric(this);
        this.metricMainType = MainMetricType.TECH_CONTRIBUTION;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getTechContributionWeight();
    }

}
