package com.github.wenhao.product.category.update.controller;

import com.github.wenhao.product.category.update.service.ProductCategoryUpdateService;
import com.github.wenhao.product.category.update.vo.ProductCategoryUpdateReqVO;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品分类更新Controller
 */
@Tag(name = "商品分类管理", description = "商品分类更新接口")
@RestController
@RequestMapping("/product/category/update")
@RequiredArgsConstructor
@Validated
public class ProductCategoryUpdateController {

    private final ProductCategoryUpdateService productCategoryUpdateService;

    @Operation(summary = "更新商品分类", description = "更新商品分类信息")
    @PutMapping
    public CommonResult<Boolean> updateCategory(@Valid @RequestBody ProductCategoryUpdateReqVO updateReqVO) {
        Boolean result = productCategoryUpdateService.updateCategory(updateReqVO);
        return CommonResult.success("更新成功", result);
    }
}