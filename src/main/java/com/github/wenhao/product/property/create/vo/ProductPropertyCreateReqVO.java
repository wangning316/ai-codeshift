package com.github.wenhao.product.property.create.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Schema(description = "商品属性项创建请求参数")
public class ProductPropertyCreateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "属性项编号")
    private Long id;

    @NotBlank(message = "名称不能为空")
    @Schema(description = "属性项名称", required = true)
    private String name;

    @Schema(description = "属性项备注")
    private String remark;
}