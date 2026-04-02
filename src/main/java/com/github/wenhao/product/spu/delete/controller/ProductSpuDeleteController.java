package com.github.wenhao.product.spu.delete.controller;

import com.github.wenhao.product.spu.delete.service.ProductSpuDeleteService;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品SPU删除Controller
 */
@Tag(name = "商品SPU管理", description = "商品SPU删除接口")
@RestController
@RequestMapping("/product/spu/delete")
@RequiredArgsConstructor
@Validated
public class ProductSpuDeleteController {

    private final ProductSpuDeleteService productSpuDeleteService;

    @Operation(summary = "删除商品SPU", description = "删除商品SPU，同步删除关联的商品SKU")
    @DeleteMapping
    public CommonResult<Boolean> deleteSpu(
        @Parameter(name = "id", description = "SPU编号", required = true)
        @RequestParam("id") Long id) {
        Boolean result = productSpuDeleteService.deleteSpu(id);
        return CommonResult.success("删除成功", result);
    }
}