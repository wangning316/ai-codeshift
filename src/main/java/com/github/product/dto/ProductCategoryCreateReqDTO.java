package com.github.product.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 商品分类创建请求DTO
 */
@Data
public class ProductCategoryCreateReqDTO {

    /**
     * 分类编号
     */
    private Long id;

    /**
     * 父分类编号
     */
    @NotNull(message = "父分类编号不能为空")
    private Long parentId;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String name;

    /**
     * 移动端分类图
     */
    @NotBlank(message = "移动端分类图不能为空")
    private String picUrl;

    /**
     * 分类排序
     */
    @NotNull
    private Integer sort;

    /**
     * 开启状态
     */
    @NotNull(message = "开启状态不能为空")
    private Integer status;

    /**
     * 分类描述
     */
    private String description;
}