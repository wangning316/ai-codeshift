package com.github.wenhao.product.history.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品浏览记录分页请求参数
 */
@Data
@Schema(description = "商品浏览记录分页请求参数")
public class ProductBrowseHistoryPageReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "页码，从 1 开始", required = false)
    private Integer pageNo = 1;

    @Schema(description = "每页条数，最大值 200", required = false)
    private Integer pageSize = 10;

    @Schema(description = "用户编号", required = false)
    private Long userId;

    @Schema(description = "用户是否删除", required = false)
    private Boolean userDeleted;

    @Schema(description = "商品SPU编号", required = false)
    private Long spuId;

    @Schema(description = "创建时间，时间范围查询", required = false)
    private LocalDateTime[] createTime;

    @Schema(description = "排序字段集合，支持多字段排序", required = false)
    private List<SortingField> sortingFields;

    /**
     * 排序字段
     */
    @Data
    @Schema(description = "排序字段")
    public static class SortingField implements Serializable {

        private static final long serialVersionUID = 1L;

        @Schema(description = "排序字段名（数据库对应字段）", required = true)
        private String field;

        @Schema(description = "排序方式：asc-升序，desc-降序", required = true)
        private String order;
    }
}