package com.archforce.demo.ddd.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.archforce.demo.ddd.api.IUserProfileService;
import com.archforce.demo.ddd.command.RefreshScoreCmdExe;
import com.archforce.demo.ddd.command.UserProfileAddCmdExe;
import com.archforce.demo.ddd.command.UserProfileUpdateCmdExe;
import com.archforce.demo.ddd.command.query.UserProfileGetQryExe;
import com.archforce.demo.ddd.command.query.UserProfileListQryExe;
import com.archforce.demo.ddd.dto.RefreshScoreCmd;
import com.archforce.demo.ddd.dto.UserProfileAddCmd;
import com.archforce.demo.ddd.dto.UserProfileGetQry;
import com.archforce.demo.ddd.dto.UserProfileListQry;
import com.archforce.demo.ddd.dto.UserProfileUpdateCmd;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * UserProfileServiceImpl
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:22 PM
 */
@Service
public class UserProfileServiceImpl implements IUserProfileService {

    @Resource
    private UserProfileAddCmdExe userProfileAddCmdExe;

    @Resource
    private UserProfileUpdateCmdExe userProfileUpdateCmdExe;

    @Resource
    private RefreshScoreCmdExe refreshScoreCmdExe;

    @Resource
    private UserProfileGetQryExe userProfileGetQryExe;

    @Resource
    private UserProfileListQryExe userProfileListQryExe;

    @Override
    public Response addUserProfile(UserProfileAddCmd userProfileAddCmd) {
        return userProfileAddCmdExe.execute(userProfileAddCmd);
    }

    @Override
    public Response updateUserProfile(UserProfileUpdateCmd cmd) {
        return userProfileUpdateCmdExe.execute(cmd);
    }

    @Override
    public Response refreshScore(RefreshScoreCmd cmd) {
        return refreshScoreCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry) {
        return userProfileGetQryExe.execute(qry);
    }

    @Override
    public MultiResponse<UserProfileCO> listUserProfileBy(UserProfileListQry qry) {
        return userProfileListQryExe.execute(qry);
    }
}
