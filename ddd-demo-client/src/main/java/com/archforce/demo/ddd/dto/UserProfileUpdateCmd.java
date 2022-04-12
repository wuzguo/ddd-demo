package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfileCO;
}
