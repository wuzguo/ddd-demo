package com.archforce.demo.ddd.domain.metrics.techcontribution;

import com.alibaba.cola.exception.Assert;
import com.alibaba.fastjson.JSON;
import com.archforce.demo.ddd.domain.metrics.MetricItem;
import lombok.Data;

/**
 * 重构指标度量项
 *
 * @author xueliang.sxl, alisa.hsh, xiangning.lxn
 */
@Data
public class RefactoringMetricItem extends MetricItem {

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 文档链接
     */
    private String docUrl;

    /**
     * 代码链接
     */
    private String codeUrl;
    /**
     * 重构的范围
     */
    private RefactoringLevel refactoringLevel;

    public RefactoringMetricItem() {
    }

    public static RefactoringMetricItem valueOf(String json) {
        return JSON.parseObject(json, RefactoringMetricItem.class);
    }

    /**
     * 计算当前度量项分数
     *
     * @return
     */
    @Override
    public double calculateScore() {
        Assert.notNull(refactoringLevel, "Refactoring Level can not be null");
        return refactoringLevel.getScore();
    }
}
