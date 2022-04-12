package com.archforce.demo.ddd.command;

import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.convertor.UserProfileConvertor;
import com.archforce.demo.ddd.domain.gateway.UserProfileGateway;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.dto.UserProfileUpdateCmd;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUpdateCmdExe {

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}