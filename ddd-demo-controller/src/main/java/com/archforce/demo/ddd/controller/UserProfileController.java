package com.archforce.demo.ddd.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.archforce.demo.ddd.api.IUserProfileService;
import com.archforce.demo.ddd.dto.UserProfileAddCmd;
import com.archforce.demo.ddd.dto.UserProfileGetQuery;
import com.archforce.demo.ddd.dto.UserProfileListQuery;
import com.archforce.demo.ddd.dto.UserProfileUpdateCmd;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import io.swagger.annotations.Api;
import java.util.Collections;
import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuzhiguo
 * @date 2022/4/21 14:07
 * @desc 描述信息
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/api")
@Api(tags = "用户信息表")
public class UserProfileController {

    @Resource
    private IUserProfileService userProfileService;

    @PostMapping(value = "/user")
    public Response addUser(@RequestBody UserProfileAddCmd userProfileAddCmd) {
        return userProfileService.addUserProfile(userProfileAddCmd);
    }

    @PostMapping(value = "/user/{userId}")
    public Response updateUser(@PathVariable("userId") @Validated @NotNull String userId,
        @RequestBody UserProfileUpdateCmd profileUpdateCmd) {
        profileUpdateCmd.getUserProfile().setUserId(userId);
        return userProfileService.updateUserProfile(profileUpdateCmd);
    }

    @GetMapping(value = "/users/{dep}")
    public MultiResponse<UserProfileCO> listUser(@PathVariable("dep") @Validated @NotBlank String dep) {
        UserProfileListQuery profileListQuery = new UserProfileListQuery();
        profileListQuery.setDep(dep);
        return userProfileService.listUserProfile(profileListQuery);
    }

    @GetMapping(value = "/users/page")
    public MultiResponse<UserProfileCO> pageUser() {
        return MultiResponse.ofWithoutTotal(Collections.emptyList());
    }

    @GetMapping(value = "/users/{userId}")
    public Response selectUser(@PathVariable("userId") @Validated @NotNull String userId) {
        UserProfileGetQuery profileGetQuery = new UserProfileGetQuery();
        profileGetQuery.setUserId(userId);
        return userProfileService.getUserProfile(profileGetQuery);
    }
}
