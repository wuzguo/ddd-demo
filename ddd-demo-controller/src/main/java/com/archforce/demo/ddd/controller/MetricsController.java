package com.archforce.demo.ddd.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.api.IMetricsService;
import com.archforce.demo.ddd.dto.ATAMetricAddCmd;
import com.archforce.demo.ddd.dto.ATAMetricQuery;
import com.archforce.demo.ddd.dto.clientobject.ATAMetricCO;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zak
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/api")
@Api(tags = "指标信息表")
public class MetricsController {

    @Resource
    private IMetricsService metricsService;

    @GetMapping(value = "/metrics/ata")
    public MultiResponse<ATAMetricCO> listATAMetrics(@RequestParam String ownerId) {
        ATAMetricQuery ataMetricQuery = new ATAMetricQuery();
        ataMetricQuery.setOwnerId(ownerId);
        return metricsService.listATAMetrics(ataMetricQuery);
    }

    @PostMapping(value = "/metrics/ata")
    public Response addATAMetric(@RequestBody ATAMetricAddCmd ataMetricAddCmd) {
        return metricsService.addATAMetric(ataMetricAddCmd);
    }
}
