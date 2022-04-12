package com.archforce.demo.ddd.dto.clientobject;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * ATAMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-01 5:39 PM
 */
@Data
public class ATAMetricCO extends AbstractMetricCO {

    @NotEmpty
    private String title;//文章标题
    private String url;//文章链接
    private long thumbsUpCount;//点赞数
    private long hitCount;//点击数
    private long commentCount;//评论数
    private long favoriteCount;//收藏数
}
