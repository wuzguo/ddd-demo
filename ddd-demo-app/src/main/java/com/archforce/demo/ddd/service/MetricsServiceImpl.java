package com.archforce.demo.ddd.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.api.IMetricsService;
import com.archforce.demo.ddd.command.ATAMetricAddCmdExe;
import com.archforce.demo.ddd.command.CodeReviewMetricAddCmdExe;
import com.archforce.demo.ddd.command.MetricDeleteCmdExe;
import com.archforce.demo.ddd.command.MiscMetricAddCmdExe;
import com.archforce.demo.ddd.command.PaperMetricAddCmdExe;
import com.archforce.demo.ddd.command.PatentMetricAddCmdExe;
import com.archforce.demo.ddd.command.RefactoringMetricAddCmdExe;
import com.archforce.demo.ddd.command.SharingMetricAddCmdExe;
import com.archforce.demo.ddd.command.query.ATAMetricQryExe;
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
    private ATAMetricAddCmdExe ataMetricAddCmdExe;

    @Resource
    private SharingMetricAddCmdExe sharingMetricAddCmdExe;

    @Resource
    private PatentMetricAddCmdExe patentMetricAddCmdExe;

    @Resource
    private PaperMetricAddCmdExe paperMetricAddCmdExe;

    @Resource
    private RefactoringMetricAddCmdExe refactoringMetricAddCmdExe;

    @Resource
    private MiscMetricAddCmdExe miscMetricAddCmdExe;

    @Resource
    private CodeReviewMetricAddCmdExe codeReviewMetricAddCmdExe;

    @Resource
    private MetricDeleteCmdExe metricDeleteCmdExe;

    @Resource
    private ATAMetricQryExe ataMetricQryExe;

    @Override
    public Response addATAMetric(ATAMetricAddCmd cmd) {
        return ataMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addSharingMetric(SharingMetricAddCmd cmd) {
        return sharingMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addPatentMetric(PatentMetricAddCmd cmd) {
        return patentMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addPaperMetric(PaperMetricAddCmd cmd) {
        return paperMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addRefactoringMetric(RefactoringMetricAddCmd cmd) {
        return refactoringMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addMiscMetric(MiscMetricAddCmd cmd) {
        return miscMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response addCodeReviewMetric(CodeReviewMetricAddCmd cmd) {
        return codeReviewMetricAddCmdExe.execute(cmd);
    }

    @Override
    public Response deleteMetric(MetricDeleteCmd cmd) {
        return metricDeleteCmdExe.execute(cmd);
    }

    @Override
    public MultiResponse<ATAMetricCO> listATAMetrics(ATAMetricQry ataMetricQry) {
        return ataMetricQryExe.execute(ataMetricQry);
    }
}
