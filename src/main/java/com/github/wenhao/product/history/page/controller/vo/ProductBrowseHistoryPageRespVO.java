package com.github.wenhao.product.history.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品浏览记录分页响应参数
 */
@Data
@Schema(description = "商品浏览记录分页响应参数")
public class ProductBrowseHistoryPageRespVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "浏览记录编号")
    private Long id;

    @Schema(description = "商品SPU编号")
    private Long spuId;

    @Schema(description = "商品SPU名称")
    private String spuName;

    @Schema(description = "商品封面图")
    private String picUrl;

    @Schema(description = "商品单价")
    private Integer price;

    @Schema(description = "商品销量")
    private Integer salesCount;

    @Schema(description = "商品库存")
    private Integer stock;
}