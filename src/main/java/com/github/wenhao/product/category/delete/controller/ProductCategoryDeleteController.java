package com.github.wenhao.product.category.delete.controller;

import com.github.wenhao.product.category.delete.service.ProductCategoryDeleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Tag(name = "商品分类_删除")
@RestController
@RequestMapping("/product/category/delete")
@RequiredArgsConstructor
public class ProductCategoryDeleteController {

    private final ProductCategoryDeleteService productCategoryDeleteService;

    @Operation(summary = "删除商品分类", description = "根据分类编号删除商品分类")
    @DeleteMapping
    public Boolean deleteProductCategory(@RequestParam @NotNull(message = "分类编号不能为空") Long id) {
        return productCategoryDeleteService.deleteProductCategory(id);
    }
}