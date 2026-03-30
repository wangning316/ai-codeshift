package com.github.wenhao.product.category.delete.controller;

import com.github.wenhao.product.category.delete.service.ProductCategoryDeleteService;
import com.github.wenhao.product.category.delete.controller.vo.DeleteProductCategoryReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "商品分类_删除")
@RestController
@RequestMapping("/product/category/delete")
@RequiredArgsConstructor
public class ProductCategoryDeleteController {

    private final ProductCategoryDeleteService productCategoryDeleteService;

    @Operation(summary = "删除商品分类", description = "根据分类编号删除商品分类")
    @DeleteMapping
    public void deleteProductCategory(@RequestBody @Valid DeleteProductCategoryReqVO reqVO) {
        productCategoryDeleteService.deleteProductCategory(reqVO.getId());
    }
}