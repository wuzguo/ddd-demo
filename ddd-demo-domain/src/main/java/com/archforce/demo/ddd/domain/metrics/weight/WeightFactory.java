package com.archforce.demo.ddd.domain.metrics.weight;

import com.archforce.demo.ddd.domain.user.Role;

public class WeightFactory {

    public static Weight get(Role role) {
        if (role == Role.DEV) {
            return DevWeight.singleton;
        }
        if (role == Role.QA) {
            return QAWeight.singleton;
        }
        return OtherWeight.singleton;
    }
}
