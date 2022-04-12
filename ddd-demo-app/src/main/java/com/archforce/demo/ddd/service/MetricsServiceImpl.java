package com.archforce.demo.ddd.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.api.IMetricsService;
import com.archforce.demo.ddd.command.ATAMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.CodeReviewMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.MetricDeleteCmdExecutor;
import com.archforce.demo.ddd.command.MiscMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.PaperMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.PatentMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.RefactoringMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.SharingMetricAddCmdExecutor;
import com.archforce.demo.ddd.command.query.ATAMetricQueryExecutor;
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
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * MetricsServiceImpl
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:41 AM
 */
@Service
public class MetricsServiceImpl implements IMetricsService {

    @Resource
    private ATAMetricAddCmdExecutor ataMetricAddCmdExecutor;

    @Resource
    private SharingMetricAddCmdExecutor sharingMetricAddCmdExecutor;

    @Resource
    private PatentMetricAddCmdExecutor patentMetricAddCmdExecutor;

    @Resource
    private PaperMetricAddCmdExecutor paperMetricAddCmdExecutor;

    @Resource
    private RefactoringMetricAddCmdExecutor refactoringMetricAddCmdExecutor;

    @Resource
    private MiscMetricAddCmdExecutor miscMetricAddCmdExecutor;

    @Resource
    private CodeReviewMetricAddCmdExecutor codeReviewMetricAddCmdExecutor;

    @Resource
    private MetricDeleteCmdExecutor metricDeleteCmdExecutor;

    @Resource
    private ATAMetricQueryExecutor ataMetricQueryExecutor;

    @Override
    public Response addATAMetric(ATAMetricAddCmd cmd) {
        return ataMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addSharingMetric(SharingMetricAddCmd cmd) {
        return sharingMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addPatentMetric(PatentMetricAddCmd cmd) {
        return patentMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addPaperMetric(PaperMetricAddCmd cmd) {
        return paperMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addRefactoringMetric(RefactoringMetricAddCmd cmd) {
        return refactoringMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addMiscMetric(MiscMetricAddCmd cmd) {
        return miscMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response addCodeReviewMetric(CodeReviewMetricAddCmd cmd) {
        return codeReviewMetricAddCmdExecutor.execute(cmd);
    }

    @Override
    public Response deleteMetric(MetricDeleteCmd cmd) {
        return metricDeleteCmdExecutor.execute(cmd);
    }

    @Override
    public MultiResponse<ATAMetricCO> listATAMetrics(ATAMetricQry ataMetricQry) {
        return ataMetricQueryExecutor.execute(ataMetricQry);
    }
}
