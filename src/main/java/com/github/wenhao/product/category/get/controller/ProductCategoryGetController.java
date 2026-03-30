package com.github.wenhao.product.category.get.controller;

import com.github.wenhao.product.category.get.service.ProductCategoryGetService;
import com.github.wenhao.product.category.get.controller.vo.ProductCategoryGetRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Tag(name = "商品分类_查询")
@RestController
@RequestMapping("/product/category/get")
@RequiredArgsConstructor
public class ProductCategoryGetController {

    private final ProductCategoryGetService productCategoryGetService;

    @Operation(summary = "查询商品分类", description = "根据分类编号查询商品分类信息")
    @GetMapping
    public ProductCategoryGetRespVO getProductCategory(@RequestParam @NotNull(message = "分类编号不能为空") Long id) {
        return productCategoryGetService.getProductCategory(id);
    }
}