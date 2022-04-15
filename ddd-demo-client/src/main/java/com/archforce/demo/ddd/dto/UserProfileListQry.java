package com.archforce.demo.ddd.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserProfileListQry extends CommonCommand {

    private String dep;
}
