package com.archforce.demo.ddd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zak
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RefreshScoreCmd extends CommonCommand {

    private String userId;
}
