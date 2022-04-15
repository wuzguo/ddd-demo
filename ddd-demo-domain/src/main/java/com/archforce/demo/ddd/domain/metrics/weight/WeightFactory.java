package com.archforce.demo.ddd.domain.metrics.weight;

import com.archforce.demo.ddd.domain.enums.RoleEnum;

public class WeightFactory {

    public static Weight get(RoleEnum role) {
        if (role == RoleEnum.DEV) {
            return DevWeight.singleton;
        }
        if (role == RoleEnum.QA) {
            return QAWeight.singleton;
        }
        return OtherWeight.singleton;
    }
}
