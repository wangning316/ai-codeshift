package com.github.wenhao.product.spu.get.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Schema(description = "商品SPU查询请求参数")
public class ProductSpuGetDetailReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "商品SPU编号不能为空")
    @Schema(description = "商品SPU编号", required = true)
    private Long id;
}