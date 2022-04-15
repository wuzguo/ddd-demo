package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.ATAMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ATAMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:12 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ATAMetricAddCmd extends CommonCommand {

    @NotNull
    private ATAMetricCO ataMetric;
}
