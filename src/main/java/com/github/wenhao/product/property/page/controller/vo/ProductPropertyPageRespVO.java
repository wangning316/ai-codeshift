package com.github.wenhao.product.property.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "商品属性项分页响应参数")
public class ProductPropertyPageRespVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "属性项编号")
    private Long id;

    @Schema(description = "属性项名称")
    private String name;

    @Schema(description = "属性项备注")
    private String remark;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}