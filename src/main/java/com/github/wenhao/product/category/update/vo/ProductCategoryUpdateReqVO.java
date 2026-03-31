package com.github.wenhao.product.category.update.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Schema(description = "商品分类更新请求参数")
public class ProductCategoryUpdateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "分类编号不能为空")
    @Schema(description = "分类编号（更新必填）", required = true)
    private Long id;

    @NotNull(message = "父分类编号不能为空")
    @Schema(description = "父分类编号", required = true)
    private Long parentId;

    @NotBlank(message = "分类名称不能为空")
    @Schema(description = "分类名称", required = true)
    private String name;

    @NotBlank(message = "移动端分类图不能为空")
    @Schema(description = "移动端分类图（建议180*180分辨率）", required = true)
    private String picUrl;

    @NotNull(message = "分类排序必填")
    @Schema(description = "分类排序", required = true)
    private Integer sort;

    @NotNull(message = "开启状态不能为空")
    @Schema(description = "开启状态", required = true)
    private Integer status;

    @Schema(description = "分类描述")
    private String description;
}