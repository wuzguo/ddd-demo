package com.archforce.demo.ddd.domain;

import com.archforce.demo.ddd.domain.metrics.techinfluence.TechInfluenceMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetric;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingMetricItem;
import com.archforce.demo.ddd.domain.metrics.techinfluence.SharingScopeEnum;
import com.archforce.demo.ddd.domain.user.UserProfile;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 * SharingMetricTest
 *
 * @author Frank Zhang
 * @date 2019-02-26 4:14 PM
 */
public class SharingMetricTest {

    @Test
    public void testSharingMetric() {
        SharingMetric sharingMetric = new SharingMetric(new TechInfluenceMetric(new UserProfile()));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.TEAM, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.BU, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.GROUP, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(new SharingMetricItem("title", SharingScopeEnum.COMMUNITY, new Date(), "sharingLink"));

        Assert.assertEquals(92, sharingMetric.calculateScore(), 0.01);
    }
}
