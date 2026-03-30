package com.github.wenhao.product.category.create.controller;

import com.github.wenhao.product.category.create.service.ProductCategoryCreateService;
import com.github.wenhao.product.category.create.controller.vo.CreateProductCategoryReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Tag(name = "商品分类_创建")
@RestController
@RequestMapping("/product/category/create")
@RequiredArgsConstructor
@Validated
public class ProductCategoryCreateController {

    private final ProductCategoryCreateService productCategoryCreateService;

    @Operation(summary = "创建商品分类", description = "创建商品分类")
    @PostMapping
    public Long createProductCategory(@RequestBody @Valid CreateProductCategoryReqVO reqVO) {
        return productCategoryCreateService.createProductCategory(reqVO);
    }
}