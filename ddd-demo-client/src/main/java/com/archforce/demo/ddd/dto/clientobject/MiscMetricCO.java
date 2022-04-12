package com.archforce.demo.ddd.dto.clientobject;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * MiscMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-04 10:58 AM
 */
@Data
public class MiscMetricCO extends AbstractMetricCO {

    /**
     * 名称
     */
    @NotEmpty
    private String name;

    /**
     * 内容
     */
    @NotEmpty
    private String content;

    /**
     * 文档链接
     */
    private String docUrl;

    /**
     * 代码链接
     */
    private String codeUrl;
}
