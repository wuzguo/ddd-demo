package com.archforce.demo.ddd.context;

import lombok.Data;

/**
 * 用户上下文
 *
 * @author Frank Zhang
 * @date 2019-02-28 7:08 PM
 */

@Data
public class UserContext {

    /**
     * 操作符
     */
    private String operator;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 用户权限
     */
    private String userPrivilege;
}
