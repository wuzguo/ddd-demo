package com.archforce.demo.ddd.dto.clientobject;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * PaperMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:16 AM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PaperMetricCO extends AbstractMetricCO {

    @NotEmpty
    private String paperName;

    private String paperDesc;

    private String magazine;

    private String paperLink;
}
