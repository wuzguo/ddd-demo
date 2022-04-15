package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.MiscMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * MiscMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:04 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MiscMetricAddCmd extends CommonCommand {

    @NotNull
    private MiscMetricCO miscMetric;
}
