package com.archforce.demo.ddd.domain;

import com.archforce.demo.ddd.domain.metrics.techinfluence.ATAMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.ATAMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.AuthorType;
import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PatentMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.PatentMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingScopeEnum;
import com.archforce.demo.ddd.domain.metrics.weight.DevWeight;
import com.archforce.demo.ddd.domain.metrics.weight.QAWeight;
import com.archforce.demo.ddd.domain.user.UserProfile;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class InfluenceMetricTest {

    @Test
    public void testDevScore() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());
        TechInfluenceMetric influenceMetric = new TechInfluenceMetric(userProfile);
        prepareSubMetrics(influenceMetric);

        Assert.assertEquals(124.5, influenceMetric.calculateScore(), 0.01);
    }

    @Test
    public void testQAScore() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new QAWeight());
        TechInfluenceMetric influenceMetric = new TechInfluenceMetric(userProfile);
        prepareSubMetrics(influenceMetric);

        Assert.assertEquals(124.5, influenceMetric.calculateScore(), 0.01);
    }

    public static void prepareSubMetrics(TechInfluenceMetric influenceMetric) {
        ATAMetric ataMetric = new ATAMetric(influenceMetric);
        ataMetric.addMetricItem(new ATAMetricItem("article", 19, 99, 14, 2));
        ataMetric.addMetricItem(new ATAMetricItem("article", 20, 100, 15, 3));
        ataMetric.addMetricItem(new ATAMetricItem("article", 100, 500, 75, 15));

        PatentMetric patentMetric = new PatentMetric(influenceMetric);
        patentMetric.addMetricItem(
            new PatentMetricItem("patentName", "patentDesc", "patentNo", "sharingLink", AuthorType.FIRST_AUTHOR));
        patentMetric.addMetricItem(
            new PatentMetricItem("patentName", "patentDesc", "patentNo", "sharingLink", AuthorType.OTHER_AUTHOR));

        SharingMetric sharingMetric = new SharingMetric(influenceMetric);
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.TEAM, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.BU, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.GROUP, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.COMMUNITY, new Date(), "sharingLink"));
    }
}
