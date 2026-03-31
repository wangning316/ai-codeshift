package com.github.wenhao.product.category.create.controller;

import com.github.wenhao.product.category.create.service.ProductCategoryCreateService;
import com.github.wenhao.product.category.create.vo.ProductCategoryCreateReqVO;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品分类创建Controller
 */
@Tag(name = "商品分类管理", description = "商品分类创建接口")
@RestController
@RequestMapping("/product/category/create")
@RequiredArgsConstructor
@Validated
public class ProductCategoryCreateController {

    private final ProductCategoryCreateService productCategoryCreateService;

    @Operation(summary = "创建商品分类", description = "创建新的商品分类")
    @PostMapping
    public CommonResult<Long> createCategory(@Valid @RequestBody ProductCategoryCreateReqVO createReqVO) {
        Long categoryId = productCategoryCreateService.createCategory(createReqVO);
        return CommonResult.success("创建成功", categoryId);
    }
}