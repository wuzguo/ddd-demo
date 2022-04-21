package com.archforce.demo.ddd.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.archforce.demo.ddd.api.IUserProfileService;
import com.archforce.demo.ddd.command.RefreshScoreCmdExecutor;
import com.archforce.demo.ddd.command.UserProfileAddCmdExecutor;
import com.archforce.demo.ddd.command.UserProfileUpdateCmdExecutor;
import com.archforce.demo.ddd.command.query.UserProfileGetQueryExecutor;
import com.archforce.demo.ddd.command.query.UserProfileListQueryExecutor;
import com.archforce.demo.ddd.dto.RefreshScoreCmd;
import com.archforce.demo.ddd.dto.UserProfileAddCmd;
import com.archforce.demo.ddd.dto.UserProfileGetQuery;
import com.archforce.demo.ddd.dto.UserProfileListQuery;
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
    private UserProfileAddCmdExecutor userProfileAddCmdExecutor;

    @Resource
    private UserProfileUpdateCmdExecutor userProfileUpdateCmdExecutor;

    @Resource
    private RefreshScoreCmdExecutor refreshScoreCmdExecutor;

    @Resource
    private UserProfileGetQueryExecutor userProfileGetQueryExecutor;

    @Resource
    private UserProfileListQueryExecutor userProfileListQueryExecutor;

    @Override
    public Response addUserProfile(UserProfileAddCmd userProfileAddCmd) {
        return userProfileAddCmdExecutor.execute(userProfileAddCmd);
    }

    @Override
    public Response updateUserProfile(UserProfileUpdateCmd cmd) {
        return userProfileUpdateCmdExecutor.execute(cmd);
    }

    @Override
    public void refreshScore(RefreshScoreCmd cmd) {
        refreshScoreCmdExecutor.execute(cmd);
    }

    @Override
    public SingleResponse<UserProfileCO> getUserProfile(UserProfileGetQuery qry) {
        return userProfileGetQueryExecutor.execute(qry);
    }

    @Override
    public MultiResponse<UserProfileCO> listUserProfile(UserProfileListQuery qry) {
        return userProfileListQueryExecutor.execute(qry);
    }
}
