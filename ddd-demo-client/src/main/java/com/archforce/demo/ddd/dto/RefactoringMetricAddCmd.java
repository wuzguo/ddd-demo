package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.RefactoringMetricCO;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * RefactoringMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:04 AM
 */
@Data
public class RefactoringMetricAddCmd extends CommonCommand {

    @NotNull
    private RefactoringMetricCO refactoringMetricCO;
}
