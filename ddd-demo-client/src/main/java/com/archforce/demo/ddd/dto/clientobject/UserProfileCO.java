package com.archforce.demo.ddd.dto.clientobject;

import com.alibaba.cola.dto.ClientObject;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zak
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserProfileCO extends ClientObject {

    public static final String IS_MANAGER = "y";

    public static final String IS_NOT_MANAGER = "n";

    public static final String DEV_ROLE = "DEV";

    public static final String QA_ROLE = "QA";

    public static final String OTHER_ROLE = "OTHER";

    /**
     * 用户ID
     */
    @NotEmpty
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 部门
     */
    private String dep;

    /**
     * 角色
     */
    private String role;

    /**
     * 是否管理员
     */
    private String isManager;

    /**
     * 综合得分
     */
    private double totalScore;

    /**
     * 代码质量分
     */
    private double appQualityScore;

    /**
     * 技术影响力分
     */
    private double techInfluenceScore;

    /**
     * 技术贡献分
     */
    private double techContributionScore;

    /**
     * 开发质量分
     */
    private double devQualityScore;

    /**
     * checkin代码量
     */
    private double checkinCodeQuantity;
}
