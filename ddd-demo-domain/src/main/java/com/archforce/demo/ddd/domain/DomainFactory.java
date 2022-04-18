package com.archforce.demo.ddd.domain;

import com.archforce.demo.ddd.domain.user.UserProfile;
import lombok.experimental.UtilityClass;

/**
 * 领域工厂类
 *
 * @author Zak
 */

@UtilityClass
public class DomainFactory {

    public static UserProfile getUserProfile() {
        return new UserProfile();
    }

}
