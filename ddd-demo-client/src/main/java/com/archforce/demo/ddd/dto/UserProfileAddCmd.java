package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * UserProfileAddCmd
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:20 PM
 */
@Data
public class UserProfileAddCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfileCO;
}
