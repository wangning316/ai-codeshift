package com.github.product.controller;

import com.github.product.common.pojo.ResponseResult;
import com.github.product.controller.vo.GetProductCategoryRespVO;
import com.github.product.service.ProductCategoryGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 独立的商品分类_查询controller类，ProductCategoryGetController。
 */
@Tag(name = "商品分类_查询")
@RestController
@RequestMapping("/product/category")
public class ProductCategoryGetController {

    @Resource
    private ProductCategoryGetService productCategoryGetService;

    /**
     * 查询商品分类
     *
     * @param id 分类编号
     * @return ResponseResult<GetProductCategoryRespVO>
     */
    @Operation(summary = "查询商品分类", description = "根据分类编号查询商品分类信息")
    @GetMapping("/get")
    public ResponseResult<GetProductCategoryRespVO> getProductCategory(
            @RequestParam @NotNull(message = "分类编号不能为空") Long id) {
        
        GetProductCategoryRespVO respVO = productCategoryGetService.getProductCategory(id);
        return ResponseResult.success(respVO);
    }
}