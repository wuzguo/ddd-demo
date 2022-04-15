package com.archforce.demo.ddd.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * MetricDeleteCmd
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:11 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MetricDeleteCmd extends CommonCommand {

    /**
     * Metric ID
     */
    private String metricId;
}
