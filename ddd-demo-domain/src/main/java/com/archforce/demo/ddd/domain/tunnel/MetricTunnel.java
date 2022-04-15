package com.archforce.demo.ddd.domain.tunnel;

import com.archforce.demo.ddd.domain.metrics.MetricItem;
import com.archforce.demo.ddd.domain.metrics.SubMetric;
import com.archforce.demo.ddd.domain.metrics.appquality.AppMetric;
import com.archforce.demo.ddd.domain.metrics.devquality.BugMetric;
import java.util.List;

/**
 * 指标接口
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:16 PM
 */
public interface MetricTunnel {

    /**
     * 保存Item
     *
     * @param metricItem {@link MetricItem}
     */
    void save(MetricItem metricItem);

    /**
     * 查询用户的技术贡献度
     *
     * @param userId 用户ID
     * @return {@link SubMetric}
     */
    List<SubMetric> listTechContributionMetric(String userId);

    /**
     * 查询用户的技术影响力
     *
     * @param userId 用户ID
     * @return {@link SubMetric}
     */
    List<SubMetric> listTechInfluenceMetric(String userId);

    /**
     * 查询BUG指标
     *
     * @param userId userId 用户ID
     * @return {@link BugMetric}
     */
    BugMetric getBugMetric(String userId);

    /**
     * 查询APP指标
     *
     * @param userId 用户ID
     * @return {@link AppMetric}
     */
    AppMetric getAppMetric(String userId);
}
