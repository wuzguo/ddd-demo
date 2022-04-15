package com.archforce.demo.ddd.common.exception;


import com.alibaba.cola.dto.ErrorCodeI;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ErrorCode
 *
 * @author Frank Zhang
 * @date 2019-01-04 11:00 AM
 */

@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeI {

    /**
     * 客户公司名冲突
     */
    CUSTOMER_COMPANY_NAME_CONFLICT("customer_companyName_conflict", "客户公司名冲突");

    /**
     * 错误编码
     */
    private final String errCode;

    /**
     * 错误描述
     */
    private final String errDesc;
}