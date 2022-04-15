package com.archforce.demo.ddd.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Role Enumeration
 *
 * @author Frank Zhang
 * @date 2018-09-13 12:25 PM
 */

@Getter
@AllArgsConstructor
public enum RoleEnum {
    /**
     * 开发
     */
    DEV("开发"),

    /**
     * 测试
     */
    QA("测试"),

    /**
     * 非技术
     */
    OTHER("非技术岗");

    /**
     * 描述
     */
    private final String desc;
}
