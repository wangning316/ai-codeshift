package com.company.project.controller;

import com.company.project.common.pojo.ResponseResult;
import com.company.project.service.ProductCategoryDeleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 商品分类_删除(controller)
 *
 * 独立的商品分类_删除controller类，ProductCategoryDeleteController。
 *
 * 接口描述: 删除商品分类
 * 请求地址: DELETE /product/category/delete
 * 请求方法: DELETE
 */
@RestController
@RequestMapping("/product/category")
@Tag(name = "商品分类管理", description = "商品分类删除相关接口")
@RequiredArgsConstructor
public class ProductCategoryDeleteController {

    private final ProductCategoryDeleteService productCategoryDeleteService;

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品分类", description = "根据分类编号删除商品分类")
    public ResponseResult<Boolean> deleteProductCategory(@RequestParam @NotNull(message = "分类编号不能为空") Long id) {
        Boolean result = productCategoryDeleteService.deleteProductCategory(id);
        return ResponseResult.success(result);
    }
}