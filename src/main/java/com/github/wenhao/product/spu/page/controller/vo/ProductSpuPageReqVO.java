package com.github.wenhao.product.spu.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品SPU分页请求参数
 */
@Data
@Schema(description = "商品SPU分页查询请求参数")
public class ProductSpuPageReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "页码，从 1 开始", required = true, example = "1")
    private Integer pageNo = 1;

    @Schema(description = "每页条数，最大值 200", required = true, example = "10")
    private Integer pageSize = 10;

    @Schema(description = "商品名称", required = false, example = "清凉小短袖")
    private String name;

    @Schema(description = "前端请求的tab类型", required = true, example = "1")
    private Integer tabType;

    @Schema(description = "商品分类编号", required = false, example = "1")
    private Long categoryId;

    @Schema(description = "创建时间范围（数组）", required = false)
    private LocalDateTime[] createTime;
}