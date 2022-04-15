package com.archforce.demo.ddd.domain.metrics.weight;

import com.archforce.demo.ddd.domain.enums.RoleEnum;

/**
 * @author Zak
 */
public class WeightFactory {

    public static Weight get(RoleEnum role) {
        if (role == RoleEnum.DEV) {
            return DevWeight.SINGLETON;
        }
        if (role == RoleEnum.QA) {
            return QAWeight.SINGLETON;
        }
        return OtherWeight.SINGLETON;
    }
}
