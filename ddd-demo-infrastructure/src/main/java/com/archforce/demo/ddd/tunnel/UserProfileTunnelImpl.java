package com.archforce.demo.ddd.tunnel;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.archforce.demo.ddd.convertor.UserProfileConvertor;
import com.archforce.demo.ddd.domain.DomainFactory;
import com.archforce.demo.ddd.domain.tunnel.UserProfileTunnel;
import com.archforce.demo.ddd.domain.metrics.techcontribution.ContributionMetric;
import com.archforce.demo.ddd.domain.metrics.weight.WeightFactory;
import com.archforce.demo.ddd.domain.user.Role;
import com.archforce.demo.ddd.domain.user.UserProfile;
import com.archforce.demo.ddd.tunnel.database.UserProfileMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.UserProfileDO;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * UserProfileGatewayImpl
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:32 PM
 */

@Component
public class UserProfileTunnelImpl implements UserProfileTunnel {

    private static Logger logger = LoggerFactory.getLogger(ContributionMetric.class);

    @Resource
    private UserProfileMapper userProfileMapper;


    public void create(UserProfile userProfile) {
        userProfileMapper.create(UserProfileConvertor.toDataObjectForCreate(userProfile));
    }

    public void update(UserProfile userProfile) {
        userProfileMapper.update(UserProfileConvertor.toDataObjectForUpdate(userProfile));
    }

    public UserProfile getByUserId(String userId) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(userId);
        if (userProfileDO == null) {
            logger.warn("There is no UserProfile for : " + userId);
            return null;
        }
        UserProfile userProfile = DomainFactory.getUserProfile();
        BeanUtils.copyProperties(userProfileDO, userProfile);
        Role role = Role.valueOf(userProfileDO.getRole());
        userProfile.setRole(role);
        userProfile.setWeight(WeightFactory.get(role));
        return userProfile;
    }

}
