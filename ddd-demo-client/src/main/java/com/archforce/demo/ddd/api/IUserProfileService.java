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

    Response addUserProfile(UserProfileAddCmd cmd);

    Response updateUserProfile(UserProfileUpdateCmd cmd);

    Response refreshScore(RefreshScoreCmd cmd);

    SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry);

    MultiResponse<UserProfileCO> listUserProfileBy(UserProfileListQry qry);
}
