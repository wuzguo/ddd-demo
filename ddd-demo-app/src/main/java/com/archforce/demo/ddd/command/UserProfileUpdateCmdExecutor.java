package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.convertor.UserProfileConvertor;
import com.archforce.demo.ddd.domain.tunnel.UserProfileTunnel;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.UserProfileUpdateCmd;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUpdateCmdExecutor {

    @Resource
    private UserProfileTunnel userProfileTunnel;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileTunnel.update(userProfile);
        return Response.buildSuccess();
    }
}