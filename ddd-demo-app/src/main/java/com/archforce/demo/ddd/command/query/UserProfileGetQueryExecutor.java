package com.archforce.demo.ddd.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.archforce.demo.ddd.dto.UserProfileGetQry;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import com.archforce.demo.ddd.tunnel.database.UserProfileMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.UserProfileDO;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserProfileGetQueryExecutor {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
