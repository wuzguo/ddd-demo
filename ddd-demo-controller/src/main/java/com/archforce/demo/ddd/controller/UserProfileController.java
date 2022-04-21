package com.archforce.demo.ddd.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/api/user")
@Api(tags = "用户信息表")
public class UserProfileController {

}
