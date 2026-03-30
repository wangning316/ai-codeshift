package com.github.wenhao.product.category.delete.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "删除商品分类请求参数")
@Data
public class DeleteProductCategoryReqVO {

    @NotNull(message = "分类编号不能为空")
    @Schema(description = "分类编号", required = true)
    private Long id;
}