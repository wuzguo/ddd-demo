package com.archforce.demo.ddd.convertor;

import com.archforce.demo.ddd.domain.user.Role;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import com.archforce.demo.ddd.tunnel.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;

public class UserProfileConvertor {

    public static UserProfile toEntity(UserProfileCO userProfileCO) {
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileCO, userProfile);
        userProfile.setRole(Role.valueOf(userProfileCO.getRole()));
        return userProfile;
    }

    public static UserProfileDO toDataObject(UserProfile userProfile) {
        UserProfileDO userProfileDO = new UserProfileDO();
        BeanUtils.copyProperties(userProfile, userProfileDO);
        userProfileDO.setRole(userProfile.getRole().name());
        return userProfileDO;
    }

    public static UserProfileDO toDataObjectForCreate(UserProfile userProfile) {
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }

    public static UserProfileDO toDataObjectForUpdate(UserProfile userProfile) {
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }
}
