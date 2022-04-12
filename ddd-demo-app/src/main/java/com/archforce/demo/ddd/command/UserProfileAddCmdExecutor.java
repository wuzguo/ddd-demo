package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.convertor.UserProfileConvertor;
import com.archforce.demo.ddd.domain.tunnel.UserProfileTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.UserProfileAddCmd;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExecutor {

    @Resource
    private UserProfileTunnel userProfileTunnel;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileTunnel.create(userProfile);
        return Response.buildSuccess();
    }
}
