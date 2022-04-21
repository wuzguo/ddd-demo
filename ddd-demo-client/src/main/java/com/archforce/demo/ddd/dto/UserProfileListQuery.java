package com.archforce.demo.ddd.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Zak
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserProfileListQuery extends CommonCommand {

    private String dep;
}
