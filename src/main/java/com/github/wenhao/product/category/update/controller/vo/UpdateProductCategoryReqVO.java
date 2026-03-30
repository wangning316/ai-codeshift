package com.github.wenhao.product.category.update.controller.vo;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateProductCategoryReqVO {
    @NotNull(message = "分类编号不能为空")
    private Long id;

    @NotNull(message = "父分类编号不能为空")
    private Long parentId;

    @NotBlank(message = "分类名称不能为空")
    private String name;

    @NotBlank(message = "移动端分类图不能为空")
    private String picUrl;

    @NotNull
    private Integer sort;

    @NotNull(message = "开启状态不能为空")
    private Integer status;

    private String description;
}