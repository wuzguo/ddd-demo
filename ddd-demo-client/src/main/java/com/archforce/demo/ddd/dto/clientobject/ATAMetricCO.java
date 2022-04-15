package com.archforce.demo.ddd.dto.clientobject;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ATAMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-01 5:39 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ATAMetricCO extends AbstractMetricCO {

    /**
     * 文章标题
     */
    @NotEmpty
    private String title;

    /**
     * 文章链接
     */
    private String url;

    /**
     * 点赞数
     */
    private long thumbsUpCount;

    /**
     * 点击数
     */
    private long hitCount;

    /**
     * 评论数
     */
    private long commentCount;

    /**
     * 收藏数
     */
    private long favoriteCount;
}
