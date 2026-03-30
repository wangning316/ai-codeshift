package com.github.wenhao.product.category.update.controller;

import com.github.wenhao.product.category.update.service.ProductCategoryUpdateService;
import com.github.wenhao.product.category.update.controller.vo.UpdateProductCategoryReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "商品分类_更新")
@RestController
@RequestMapping("/product/category/update")
@RequiredArgsConstructor
public class ProductCategoryUpdateController {

    private final ProductCategoryUpdateService productCategoryUpdateService;

    @Operation(summary = "更新商品分类", description = "根据分类编号更新商品分类信息")
    @PutMapping
    public void updateProductCategory(@RequestBody @Valid UpdateProductCategoryReqVO reqVO) {
        productCategoryUpdateService.updateProductCategory(reqVO);
    }
}