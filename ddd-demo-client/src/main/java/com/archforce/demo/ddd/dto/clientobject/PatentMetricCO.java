package com.archforce.demo.ddd.dto.clientobject;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * PatentMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:16 AM
 */
@Data
public class PatentMetricCO extends AbstractMetricCO {

    public static final String FIRST_AUTHOR_TYPE = "FIRST_AUTHOR";
    public static final String OTHER_AUTHOR_TYPE = "OTHER_AUTHOR";

    @NotEmpty
    private String patentName;
    private String patentDesc;
    private String patentNo;
    private String patentUrl;
    private String authorType;
}
