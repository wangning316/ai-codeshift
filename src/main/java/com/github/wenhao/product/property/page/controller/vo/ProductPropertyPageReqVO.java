package com.github.wenhao.product.property.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "商品属性项分页请求参数")
public class ProductPropertyPageReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "页码，从 1 开始", required = false)
    private Integer pageNo = 1;

    @Schema(description = "每页条数，最大值 200", required = false)
    private Integer pageSize = 10;

    @Schema(description = "属性项名称", required = false)
    private String name;

    @Schema(description = "状态", required = false)
    private Integer status;

    @Schema(description = "创建时间范围（数组）", required = false)
    private LocalDateTime[] createTime;
}