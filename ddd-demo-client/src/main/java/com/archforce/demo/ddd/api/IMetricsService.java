package com.archforce.demo.ddd.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.dto.ATAMetricAddCmd;
import com.archforce.demo.ddd.dto.ATAMetricQry;
import com.archforce.demo.ddd.dto.CodeReviewMetricAddCmd;
import com.archforce.demo.ddd.dto.MetricDeleteCmd;
import com.archforce.demo.ddd.dto.MiscMetricAddCmd;
import com.archforce.demo.ddd.dto.PaperMetricAddCmd;
import com.archforce.demo.ddd.dto.PatentMetricAddCmd;
import com.archforce.demo.ddd.dto.RefactoringMetricAddCmd;
import com.archforce.demo.ddd.dto.SharingMetricAddCmd;
import com.archforce.demo.ddd.dto.clientobject.ATAMetricCO;

/**
 * MetricsServiceI
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:06 AM
 */
public interface IMetricsService {

    /**
     * @param cmd {@link ATAMetricAddCmd}
     * @return {@link Response}
     */
    Response addATAMetric(ATAMetricAddCmd cmd);

    /**
     * @param cmd {@link SharingMetricAddCmd}
     * @return {@link Response}
     */
    Response addSharingMetric(SharingMetricAddCmd cmd);

    /**
     * 添加专利指标
     * @param cmd {@link PatentMetricAddCmd}
     * @return {@link Response}
     */
    Response addPatentMetric(PatentMetricAddCmd cmd);

    /**
     * 添加专利指标
     *
     * @param cmd {@link PaperMetricAddCmd}
     * @return {@link Response}
     */
    Response addPaperMetric(PaperMetricAddCmd cmd);

    /**
     * 添加重构指标
     *
     * @param cmd {@link RefactoringMetricAddCmd}
     * @return {@link Response}
     */
    Response addRefactoringMetric(RefactoringMetricAddCmd cmd);

    /**
     * 添加MISC指标
     *
     * @param cmd {@link MiscMetricAddCmd}
     * @return {@link Response}
     */
    Response addMiscMetric(MiscMetricAddCmd cmd);

    /**
     * 新增代码审查指标
     *
     * @param cmd {@link CodeReviewMetricAddCmd}
     * @return {@link Response}
     */
    Response addCodeReviewMetric(CodeReviewMetricAddCmd cmd);

    /**
     * 删除指标
     *
     * @param cmd {@link MetricDeleteCmd}
     * @return {@link Response}
     */
    Response deleteMetric(MetricDeleteCmd cmd);

    /**
     * 查询ATA统计指标
     *
     * @param ataMetricQry {@link ATAMetricQry}
     * @return {@link ATAMetricCO}
     */
    MultiResponse<ATAMetricCO> listATAMetrics(ATAMetricQry ataMetricQry);
}
