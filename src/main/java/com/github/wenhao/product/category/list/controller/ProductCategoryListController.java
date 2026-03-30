package com.github.wenhao.product.category.list.controller;

import com.github.wenhao.product.category.list.service.ProductCategoryListService;
import com.github.wenhao.product.category.list.controller.vo.ProductCategoryListReqVO;
import com.github.wenhao.product.category.list.controller.vo.ProductCategoryListRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品分类_查询列表")
@RestController
@RequestMapping("/product/category/list")
@RequiredArgsConstructor
public class ProductCategoryListController {

    private final ProductCategoryListService productCategoryListService;

    @Operation(summary = "获得商品分类列表", description = "获得商品分类列表")
    @GetMapping
    public List<ProductCategoryListRespVO> listProductCategories(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) List<Long> parentIds) {
        
        ProductCategoryListReqVO reqVO = new ProductCategoryListReqVO();
        reqVO.setName(name);
        reqVO.setStatus(status);
        reqVO.setParentId(parentId);
        reqVO.setParentIds(parentIds);

        return productCategoryListService.listProductCategories(reqVO);
    }
}