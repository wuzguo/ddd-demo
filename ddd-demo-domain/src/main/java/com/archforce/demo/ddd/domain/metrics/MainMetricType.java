package com.archforce.demo.ddd.domain.metrics;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Zak
 */

@Getter
@AllArgsConstructor
public enum MainMetricType {

    /**
     * 应用质量
     */
    APP_QUALITY("app-quality", "应用质量"),

    /**
     * 技术影响力
     */
    TECH_INFLUENCE("tech-influence", "技术影响力"),

    /**
     * 技术贡献
     */
    TECH_CONTRIBUTION("tech-contribution", "技术贡献"),

    /**
     * 开发质量
     */
    DEV_QUALITY("dev-quality", "开发质量");

    private final String code;

    private final String name;


    public static MainMetricType codeOf(String code) {
        if (code == null) {
            return null;
        }
        for (MainMetricType metricMainType : MainMetricType.values()) {
            if (code.equals(metricMainType.code)) {
                return metricMainType;
            }
        }
        return null;
    }
}
