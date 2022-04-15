package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.SharingMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SharingMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:12 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SharingMetricAddCmd extends CommonCommand {

    @NotNull
    private SharingMetricCO sharingMetric;
}
