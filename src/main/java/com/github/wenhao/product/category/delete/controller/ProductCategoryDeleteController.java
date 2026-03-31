package com.github.wenhao.product.category.delete.controller;

import com.github.wenhao.product.category.delete.service.ProductCategoryDeleteService;
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
 * 商品分类删除Controller
 */
@Tag(name = "商品分类管理", description = "商品分类删除接口")
@RestController
@RequestMapping("/product/category/delete")
@RequiredArgsConstructor
@Validated
public class ProductCategoryDeleteController {

    private final ProductCategoryDeleteService productCategoryDeleteService;

    @Operation(summary = "删除商品分类", description = "删除商品分类")
    @DeleteMapping
    public CommonResult<Boolean> deleteCategory(
        @Parameter(name = "id", description = "分类编号", required = true) 
        @RequestParam("id") Long id) {
        Boolean result = productCategoryDeleteService.deleteCategory(id);
        return CommonResult.success("删除成功", result);
    }
}