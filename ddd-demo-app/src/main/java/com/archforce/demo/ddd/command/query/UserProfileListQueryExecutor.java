package com.archforce.demo.ddd.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.archforce.demo.ddd.dto.UserProfileListQry;
import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import com.archforce.demo.ddd.tunnel.database.UserProfileMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.UserProfileDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserProfileListQueryExecutor {

    @Resource
    private UserProfileMapper userProfileMapper;

    public MultiResponse<UserProfileCO> execute(UserProfileListQry qry) {
        List<UserProfileDO> userProfileDOList = userProfileMapper.listByDep(qry.getDep());
        List<UserProfileCO> userProfileCOList = new ArrayList<>();
        userProfileDOList.forEach(userDO -> {
            UserProfileCO userProfileCO = new UserProfileCO();
            BeanUtils.copyProperties(userDO, userProfileCO);
            userProfileCOList.add(userProfileCO);
        });
        return MultiResponse.ofWithoutTotal(userProfileCOList);
    }

}

