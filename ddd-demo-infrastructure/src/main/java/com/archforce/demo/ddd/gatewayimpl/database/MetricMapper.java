package com.archforce.demo.ddd.gatewayimpl.database;

import com.archforce.demo.ddd.gatewayimpl.database.dataobject.MetricDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MetricMapper {

    int create(MetricDO dataObject);

    List<MetricDO> listByUserId(@Param("userId") String userId);

    List<MetricDO> listByMainMetric(@Param("userId") String userId, @Param("mainMetric") String mainMetric);

    List<MetricDO> listBySubMetric(@Param("userId") String userId, @Param("subMetric") String subMetric);

    int delete(@Param("id") String id, @Param("modifier") String modifier);

    MetricDO getById(@Param("id") String id);
}
