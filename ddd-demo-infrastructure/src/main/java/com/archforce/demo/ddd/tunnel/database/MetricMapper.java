package com.archforce.demo.ddd.tunnel.database;

import com.archforce.demo.ddd.tunnel.database.dataobject.MetricDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MetricMapper {

    /**
     * 创建指标
     *
     * @param metric {@link MetricDO}
     * @return 创建结果
     */
    int create(MetricDO metric);

    /**
     * 根据用户ID查询
     *
     * @param userId 用户ID
     * @return @return {@link MetricDO}
     */
    List<MetricDO> listByUserId(@Param("userId") String userId);

    /**
     * 查询主指标
     *
     * @param userId     用户ID
     * @param mainMetric 主指标ID
     * @return {@link MetricDO}
     */

    List<MetricDO> listByMainMetric(@Param("userId") String userId, @Param("mainMetric") String mainMetric);

    /**
     * 查询子指标
     *
     * @param userId    用户ID
     * @param subMetric 子指标ID
     * @return {@link MetricDO}
     */
    List<MetricDO> listBySubMetric(@Param("userId") String userId, @Param("subMetric") String subMetric);

    /**
     * 删除
     *
     * @param id       指标ID
     * @param modifier 修改人
     */
    void delete(@Param("id") String id, @Param("modifier") String modifier);

    /**
     * 查询
     *
     * @param id 指标ID
     * @return {@link MetricDO}
     */
    MetricDO select(@Param("id") String id);
}
