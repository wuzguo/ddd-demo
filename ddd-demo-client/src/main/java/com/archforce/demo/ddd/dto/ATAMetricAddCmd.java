package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.ATAMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * ATAMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:12 AM
 */
@Data
public class ATAMetricAddCmd extends CommonCommand {

    @NotNull
    private ATAMetricCO ataMetricCO;
}
