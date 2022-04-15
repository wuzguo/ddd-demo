package com.archforce.demo.ddd.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.archforce.demo.ddd.dto.RefreshScoreCmd;
import com.archforce.demo.ddd.dto.UserProfileAddCmd;
import com.archforce.demo.ddd.dto.UserProfileGetQry;
import com.archforce.demo.ddd.dto.UserProfileListQry;
import com.archforce.demo.ddd.dto.UserProfileUpdateCmd;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;


/**
 * UserProfileServiceI
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:15 PM
 */
public interface IUserProfileService {

    /**
     * 新增用户信息
     *
     * @param cmd {@link UserProfileAddCmd}
     * @return {@link Response}
     */
    Response addUserProfile(UserProfileAddCmd cmd);

    /**
     * 更新用户信息
     *
     * @param cmd {@link UserProfileUpdateCmd}
     * @return {@link Response}
     */
    Response updateUserProfile(UserProfileUpdateCmd cmd);

    /**
     * 更新Score
     *
     * @param cmd {@link RefreshScoreCmd}
     */
    void refreshScore(RefreshScoreCmd cmd);

    /**
     * 获取用户信息
     *
     * @param qry {@link UserProfileGetQry}
     * @return {@link UserProfileCO}
     */
    SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry);


    /**
     * 查询用户信息
     *
     * @param qry {@link UserProfileListQry}
     * @return {@link UserProfileCO}
     */
    MultiResponse<UserProfileCO> listUserProfile(UserProfileListQry qry);
}
