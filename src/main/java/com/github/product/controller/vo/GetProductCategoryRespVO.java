package com.github.product.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 查询商品分类-响应参数
 */
@Data
public class GetProductCategoryRespVO {

    @Schema(description = "分类编号")
    private Long id;

    @Schema(description = "父分类编号")
    private Long parentId;

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "移动端分类图")
    private String picUrl;

    @Schema(description = "分类排序")
    private Integer sort;

    @Schema(description = "开启状态")
    private Integer status;

    @Schema(description = "分类描述")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}