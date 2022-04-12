package com.archforce.demo.ddd.domain;

import com.archforce.demo.ddd.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile() {
        return new UserProfile();
    }

}
