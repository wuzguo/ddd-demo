package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.PatentMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * PatentMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:37 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PatentMetricAddCmd extends CommonCommand {

    @NotNull
    private PatentMetricCO patentMetric;
}
