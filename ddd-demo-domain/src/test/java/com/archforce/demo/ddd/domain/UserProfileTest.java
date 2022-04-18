package com.archforce.demo.ddd.domain;

import com.alibaba.cola.exception.BizException;
import com.archforce.demo.ddd.domain.metrics.appquality.AppMetric;
import com.archforce.demo.ddd.domain.metrics.appquality.AppMetricItem;
import com.archforce.demo.ddd.domain.metrics.appquality.AppQualityMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.BugMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.BugMetricItem;
import com.archforce.demo.ddd.domain.metrics.devquality.DevQualityMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.CodeReviewMetric;
import com.archforce.demo.ddd.domain.metrics.techcontribution.CodeReviewMetricItem;
import com.archforce.demo.ddd.domain.metrics.techcontribution.TechContributionMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.weight.DevWeight;
import com.archforce.demo.ddd.domain.user.UserProfile;
import org.junit.Assert;
import org.junit.Test;

/**
 * UserProfileTest
 *
 * @author Frank Zhang
 * @date 2020-08-28 2:03 PM
 */
public class UserProfileTest {

    @Test
    public void testCalculateScore() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());

        //App Quality Metric
        AppMetricItem appMetricItem1 = new AppMetricItem();
        appMetricItem1.setAppName("app1");
        appMetricItem1.setCyclomaticComplexityCount(200);
        appMetricItem1.setDuplicatedMethodCount(80);
        appMetricItem1.setLongMethodCount(70);
        appMetricItem1.setBlockedCodeConductCount(20);
        appMetricItem1.calculateScore();

        AppMetricItem appMetricItem2 = new AppMetricItem();
        appMetricItem2.setAppName("app2");
        appMetricItem2.setCyclomaticComplexityCount(20);
        appMetricItem2.setDuplicatedMethodCount(30);
        appMetricItem2.setLongMethodCount(7);
        appMetricItem2.setBlockedCodeConductCount(5);
        appMetricItem2.calculateScore();

        AppMetric appMetric = new AppMetric();
        appMetric.addMetricItem(appMetricItem1);
        appMetric.addMetricItem(appMetricItem2);

        AppQualityMetric appQualityMetric = new AppQualityMetric(userProfile);
        appMetric.setParent(appQualityMetric);

        //influence Metric
        TechInfluenceMetric influenceMetric = new TechInfluenceMetric(userProfile);
        InfluenceMetricTest.prepareSubMetrics(influenceMetric);

        //techContribution Metric
        CodeReviewMetric codeReviewMetric = new CodeReviewMetric();
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        codeReviewMetricItem.setNoteCount(4);
        codeReviewMetricItem.setReviewId("12234455");
        codeReviewMetric.addMetricItem(codeReviewMetricItem);
        TechContributionMetric contributionMetric = new TechContributionMetric(userProfile);

        //dev quality metric
        DevQualityMetric devQualityMetric = new DevQualityMetric(userProfile);
        BugMetric bugMetric = new BugMetric();
        BugMetricItem bugMetricItem = new BugMetricItem(2, 1000);
        bugMetric.addMetricItem(bugMetricItem);
        devQualityMetric.setBugMetric(bugMetric);

        //Execution
        userProfile.calculateScore();

        //Assertion
        Assert.assertEquals(45.8, userProfile.getTotalScore(), 0.01);
    }

    @Test(expected = BizException.class)
    public void testNPE() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());

        userProfile.calculateScore();
    }
}
