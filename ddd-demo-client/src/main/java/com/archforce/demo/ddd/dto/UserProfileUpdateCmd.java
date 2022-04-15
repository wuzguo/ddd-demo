package com.archforce.demo.ddd.dto;

import com.archforce.demo.ddd.dto.clientobject.UserProfileCO;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfile;
}
