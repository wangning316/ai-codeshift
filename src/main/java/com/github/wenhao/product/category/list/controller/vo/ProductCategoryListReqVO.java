package com.github.wenhao.product.category.list.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "商品分类列表查询请求对象")
@Data
public class ProductCategoryListReqVO {

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "开启状态")
    private Integer status;

    @Schema(description = "父分类编号")
    private Long parentId;

    @Schema(description = "父分类编号数组")
    private List<Long> parentIds;
}