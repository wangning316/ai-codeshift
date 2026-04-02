package com.github.wenhao.product.spu.list.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Data
@Schema(description = "商品SPU列表查询请求参数")
public class ProductSpuListReqVO {

    @NotEmpty(message = "商品SPU编号列表不能为空")
    @Schema(description = "商品SPU编号列表", example = "[1,2,3]")
    private Collection<Long> spuIds;

}