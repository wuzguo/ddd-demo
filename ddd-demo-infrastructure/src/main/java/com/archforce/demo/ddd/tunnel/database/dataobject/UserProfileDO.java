package com.archforce.demo.ddd.tunnel.database.dataobject;


/**
 * UserProfileDO
 *
 * @author Frank Zhang
 * @date 2019-02-27 5:00 PM
 */

public class UserProfileDO extends BaseDO {

    /**
     * 域账号
     */
    private String userId;

    /**
     * 姓名
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
     * 是否主管
     */
    private String isManager;

    /**
     * 综合得分
     */
    private Double totalScore;

    /**
     * 代码质量分
     */
    private Double appQualityScore;

    /**
     * 技术影响力分
     */
    private Double techInfluenceScore;

    /**
     * 技术贡献分
     */
    private Double techContributionScore;

    /**
     * 开发质量分
     */
    private Double devQualityScore;

    /**
     * checkin代码量
     */
    private Double codeReviewQuantity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getAppQualityScore() {
        return appQualityScore;
    }

    public void setAppQualityScore(Double appQualityScore) {
        this.appQualityScore = appQualityScore;
    }

    public Double getTechInfluenceScore() {
        return techInfluenceScore;
    }

    public void setTechInfluenceScore(Double techInfluenceScore) {
        this.techInfluenceScore = techInfluenceScore;
    }

    public Double getTechContributionScore() {
        return techContributionScore;
    }

    public void setTechContributionScore(Double techContributionScore) {
        this.techContributionScore = techContributionScore;
    }

    public Double getDevQualityScore() {
        return devQualityScore;
    }

    public void setDevQualityScore(Double devQualityScore) {
        this.devQualityScore = devQualityScore;
    }

    public Double getCodeReviewQuantity() {
        return codeReviewQuantity;
    }

    public void setCodeReviewQuantity(Double codeReviewQuantity) {
        this.codeReviewQuantity = codeReviewQuantity;
    }

    @Override
    public String toString() {
        return "UserProfileDO{" +
            "userId='" + userId + '\'' +
            ", userName='" + userName + '\'' +
            ", dep='" + dep + '\'' +
            ", role='" + role + '\'' +
            ", isManager='" + isManager + '\'' +
            ", totalScore=" + totalScore +
            ", appQualityScore=" + appQualityScore +
            ", techInfluenceScore=" + techInfluenceScore +
            ", techContributionScore=" + techContributionScore +
            ", devQualityScore=" + devQualityScore +
            ", codeReviewQuantity=" + codeReviewQuantity +
            '}';
    }
}
