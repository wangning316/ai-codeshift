package com.company.project.controller;

import com.company.project.common.pojo.Result;
import com.company.project.dto.CreateProductCategoryDTO;
import com.company.project.entity.po.ProductCategoryPO;
import com.company.project.exception.BusinessException;
import com.company.project.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Result<Long> createProductCategory(@Valid @RequestBody CreateProductCategoryDTO createProductCategoryDTO) {
        Long categoryId = productCategoryService.createProductCategory(createProductCategoryDTO);
        return Result.success(categoryId);
    }

    @ApiOperation(value = "查询商品分类", notes = "根据分类编号查询商品分类")
    @GetMapping("/get")
    public Result<ProductCategoryPO> getProductCategory(@ApiParam(value = "分类编号", required = true) @RequestParam Long id) {
        ProductCategoryPO productCategory = productCategoryService.getProductCategory(id);
        return Result.success(productCategory);
    }
    
    @ApiOperation(value = "删除商品分类", notes = "根据分类编号删除商品分类")
    @DeleteMapping("/delete")
    public Result<Boolean> deleteProductCategory(@ApiParam(value = "分类编号", required = true) @RequestParam Long id) {
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
            @ApiParam(value = "分类名称") @RequestParam(required = false) String name,
            @ApiParam(value = "开启状态") @RequestParam(required = false) Integer status,
            @ApiParam(value = "父分类编号") @RequestParam(required = false) Long parentId,
            @ApiParam(value = "父分类编号数组") @RequestParam(required = false) java.util.List<Long> parentIds) {
        java.util.List<ProductCategoryPO> productCategories = productCategoryService.getProductCategoryList(name, status, parentId, parentIds);
        return Result.success(productCategories);
    }
}