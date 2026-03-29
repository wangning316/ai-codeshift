package com.github.product.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 查询商品分类列表-请求参数
 */
@Data
public class GetProductCategoryListReqVO {

    @Schema(description = "父分类编号")
    private Long parentId;

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "开启状态")
    private Integer status;
}