package com.archforce.demo.ddd.tunnel;

import com.archforce.demo.ddd.tunnel.database.UserProfileMapper;
import com.archforce.demo.ddd.tunnel.database.dataobject.UserProfileDO;
import javax.annotation.Resource;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This is Tunnel Test, no need to mock, and no regression needed as well
 *
 * @author Frank Zhang
 * @date 2019-02-27 5:31 PM
 */

@SpringBootTest
public class UserProfileTunnelTest {

    @Resource
    private UserProfileMapper userProfileMapper;

    public void testCRUD() {
        String userId = Math.random() + "UserProfileTunnelTest";

        UserProfileDO userProfileDO = new UserProfileDO();
        userProfileDO.setUserId(userId);
        userProfileDO.setDep("alibaba");
        userProfileDO.setIsManager("n");
        userProfileDO.setUserName("Frank");
        userProfileDO.setRole("DEV");

        userProfileMapper.create(userProfileDO);

        userProfileDO = userProfileMapper.getByUserId(userId);
        Assert.assertEquals(userId, userProfileDO.getUserId());

        userProfileMapper.delete(userId);
        Assert.assertNull(userProfileMapper.getByUserId(userId));
    }
}
