package com.archforce.demo.ddd.domain.metrics.appquality;

import com.archforce.demo.ddd.domain.metrics.MetricItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Zak
 */


@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class AppMetricItem extends MetricItem {

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 圈复杂度超标的数目
     */
    private int cyclomaticComplexityCount;

    /**
     * 重复代码的数目
     */
    private int duplicatedMethodCount;

    /**
     * 长方法的数目
     */
    private int longMethodCount;

    /**
     * 不符合编码标准的数目
     */
    private int blockedCodeConductCount;

    private static final int FULL_SCORE = 100;

    private static final int STEP_SIZE = 10;

    private static final int STEP_MINUS_SCORE = 1;

    @Override
    public double calculateScore() {
        double score = FULL_SCORE;
        score = deductScore(score, cyclomaticComplexityCount);
        score = deductScore(score, duplicatedMethodCount);
        score = deductScore(score, longMethodCount);
        score = deductScore(score, blockedCodeConductCount);
        log.debug("calculated App score is " + score);
        return score;
    }

    private double deductScore(double score, int count) {
        for (int counter = STEP_SIZE; counter <= count; counter = counter + STEP_SIZE) {
            score = score - STEP_MINUS_SCORE;
        }
        return score;
    }
}