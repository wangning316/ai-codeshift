package com.company.project.controller;

import com.company.project.common.pojo.Result;
import com.company.project.entity.po.ProductCategoryPO;
import com.company.project.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品分类控制器
 */
@Api(tags = "商品分类")
@RestController
@RequestMapping("/product/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation(value = "创建商品分类", notes = "创建商品分类")
    @PostMapping("/create")
    public Result<Long> createProductCategory(@RequestBody ProductCategoryPO productCategory) {
        Long categoryId = productCategoryService.createProductCategory(productCategory);
        return Result.success(categoryId);
    }

    @ApiOperation(value = "查询商品分类", notes = "根据分类编号查询商品分类")
    @GetMapping("/get")
    public Result<ProductCategoryPO> getProductCategory(@RequestParam Long id) {
        ProductCategoryPO productCategory = productCategoryService.getProductCategory(id);
        return Result.success(productCategory);
    }
    
    @ApiOperation(value = "删除商品分类", notes = "根据分类编号删除商品分类")
    @DeleteMapping("/delete")
    public Result<Boolean> deleteProductCategory(@RequestParam Long id) {
        Boolean result = productCategoryService.deleteProductCategory(id);
        return Result.success(result);
    }
    
    @ApiOperation(value = "更新商品分类", notes = "更新商品分类")
    @PutMapping("/update")
    public Result<Boolean> updateProductCategory(@RequestBody ProductCategoryPO productCategory) {
        Boolean result = productCategoryService.updateProductCategory(productCategory);
        return Result.success(result);
    }
    
    @ApiOperation(value = "查询商品分类列表", notes = "根据分类名称、开启状态、父分类编号、父分类编号数组查询商品分类列表")
    @GetMapping("/list")
    public Result<java.util.List<ProductCategoryPO>> getProductCategoryList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) java.util.List<Long> parentIds) {
        java.util.List<ProductCategoryPO> productCategories = productCategoryService.getProductCategoryList(name, status, parentId, parentIds);
        return Result.success(productCategories);
    }
}