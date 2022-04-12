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

    Response addATAMetric(ATAMetricAddCmd cmd);

    Response addSharingMetric(SharingMetricAddCmd cmd);

    Response addPatentMetric(PatentMetricAddCmd cmd);

    Response addPaperMetric(PaperMetricAddCmd cmd);

    Response addRefactoringMetric(RefactoringMetricAddCmd cmd);

    Response addMiscMetric(MiscMetricAddCmd cmd);

    Response addCodeReviewMetric(CodeReviewMetricAddCmd cmd);

    Response deleteMetric(MetricDeleteCmd cmd);

    MultiResponse<ATAMetricCO> listATAMetrics(ATAMetricQry ataMetricQry);
}
