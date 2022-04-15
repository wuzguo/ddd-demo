package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.PaperMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * PaperMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:38 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PaperMetricAddCmd extends CommonCommand {

    @NotNull
    private PaperMetricCO paperMetric;
}