package com.github.product.controller;

import com.github.product.common.pojo.ResponseResult;
import com.github.product.controller.vo.CreateProductCategoryReqVO;
import com.github.product.service.ProductCategoryCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品分类_创建(controller)
 *
 * 独立的商品分类_创建controller类，ProductCategoryCreateController。
 *
 * 接口描述: 创建商品分类
 * 请求地址: POST /product/category/create
 * 请求方法: POST
 */
@RestController
@RequestMapping("/product/category")
@Tag(name = "商品分类管理", description = "商品分类创建相关接口")
@RequiredArgsConstructor
public class ProductCategoryCreateController {

    private final ProductCategoryCreateService productCategoryCreateService;

    @PostMapping("/create")
    @Operation(summary = "创建商品分类", description = "创建新的商品分类")
    public ResponseResult<Long> createProductCategory(@Valid @RequestBody CreateProductCategoryReqVO reqVO) {
        Long categoryId = productCategoryCreateService.createProductCategory(
                reqVO.getParentId(),
                reqVO.getName(),
                reqVO.getPicUrl(),
                reqVO.getSort(),
                reqVO.getStatus(),
                reqVO.getDescription()
        );
        return ResponseResult.success(categoryId);
    }
}