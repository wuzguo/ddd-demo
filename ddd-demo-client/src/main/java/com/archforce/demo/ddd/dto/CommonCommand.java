package com.archforce.demo.ddd.dto;

import com.alibaba.cola.dto.Command;

/**
 * 整个应用通用的Command
 *
 * @author Frank Zhang
 * @date 2019-02-28 7:18 PM
 */

public class CommonCommand extends Command {

    private String operator;

    private boolean needsOperator;

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        needsOperator = true;
    }

    public boolean isNeedsOperator() {
        return needsOperator;
    }
}
