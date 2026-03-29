package com.github.product.controller;

import com.github.product.common.pojo.ResponseResult;
import com.github.product.controller.vo.UpdateProductCategoryReqVO;
import com.github.product.service.ProductCategoryUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品分类_更新(controller)
 *
 * 独立的商品分类_更新controller类，ProductCategoryUpdateController。
 *
 * 接口描述: 更新商品分类
 * 请求地址: PUT /product/category/update
 * 请求方法: PUT
 */
@RestController
@RequestMapping("/product/category")
@Tag(name = "商品分类管理", description = "商品分类更新相关接口")
@RequiredArgsConstructor
public class ProductCategoryUpdateController {

    private final ProductCategoryUpdateService productCategoryUpdateService;

    @PutMapping("/update")
    @Operation(summary = "更新商品分类", description = "更新商品分类信息")
    public ResponseResult<Boolean> updateProductCategory(@Valid @RequestBody UpdateProductCategoryReqVO reqVO) {
        Boolean result = productCategoryUpdateService.updateProductCategory(reqVO);
        return ResponseResult.success(result);
    }
}