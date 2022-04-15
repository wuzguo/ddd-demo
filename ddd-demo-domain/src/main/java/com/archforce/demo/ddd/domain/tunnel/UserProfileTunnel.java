package com.archforce.demo.ddd.domain.tunnel;

import com.archforce.demo.ddd.domain.user.UserProfile;

/**
 * UserProfileGateway
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:16 PM
 */

public interface UserProfileTunnel {

    /**
     * 创建用户信息
     *
     * @param userProfile {@link UserProfile}
     */
    void create(UserProfile userProfile);

    /**
     * 更新用户信息
     *
     * @param userProfile {@link UserProfile}
     */
    void update(UserProfile userProfile);

    /**
     * @param userId 用户ID
     * @return {@link UserProfile}
     */
    UserProfile getProfile(String userId);
}
