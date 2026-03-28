package com.company.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 创建商品分类请求DTO
 */
@Data
@ApiModel(description = "创建商品分类请求DTO")
public class CreateProductCategoryDTO {

    /**
     * 父分类编号
     */
    @ApiModelProperty(value = "父分类编号", required = true, example = "0")
    @NotNull(message = "父分类编号不能为空")
    private Long parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", required = true, example = "电子产品")
    @NotBlank(message = "分类名称不能为空")
    @Size(max = 50, message = "分类名称长度不能超过50个字符")
    private String name;

    /**
     * 移动端分类图
     */
    @ApiModelProperty(value = "移动端分类图", required = true, example = "http://example.com/image.jpg")
    @NotBlank(message = "移动端分类图不能为空")
    @Size(max = 200, message = "分类图URL长度不能超过200个字符")
    private String picUrl;

    /**
     * 分类排序
     */
    @ApiModelProperty(value = "分类排序", required = true, example = "1")
    @NotNull(message = "分类排序不能为空")
    @Min(value = 0, message = "分类排序不能小于0")
    @Max(value = 99999, message = "分类排序不能大于99999")
    private Integer sort;

    /**
     * 开启状态
     */
    @ApiModelProperty(value = "开启状态", required = true, example = "1")
    @NotNull(message = "开启状态不能为空")
    @Min(value = 0, message = "开启状态不能小于0")
    @Max(value = 1, message = "开启状态不能大于1")
    private Integer status;

    /**
     * 分类描述
     */
    @ApiModelProperty(value = "分类描述", example = "电子产品分类")
    @Size(max = 200, message = "分类描述长度不能超过200个字符")
    private String description;
}