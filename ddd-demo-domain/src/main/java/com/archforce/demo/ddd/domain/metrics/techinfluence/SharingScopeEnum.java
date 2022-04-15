package com.archforce.demo.ddd.domain.metrics.techinfluence;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SharingScope 线下分享的范围，范围不同，分值不同
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:25 PM
 */

@Getter
@AllArgsConstructor
public enum SharingScopeEnum {

    /**
     * 团队内分享
     */
    TEAM(2, "团队内分享"),

    /**
     * BU内部分享
     */
    BU(20, "BU内部分享"),

    /**
     * 集团内部分享
     */
    GROUP(30, "集团内部分享"),

    /**
     * 公众外部分享
     */
    COMMUNITY(40, "公众外部分享");


    /**
     * 分数
     */
    private final double score;

    /**
     * 描述
     */
    private final String desc;
}
