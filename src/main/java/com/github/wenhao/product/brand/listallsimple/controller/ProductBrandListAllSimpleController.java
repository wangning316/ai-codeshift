package com.github.wenhao.product.brand.listallsimple.controller;

import com.github.wenhao.product.brand.listallsimple.controller.vo.ProductBrandListAllSimpleRespVO;
import com.github.wenhao.product.brand.listallsimple.service.ProductBrandListAllSimpleService;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品品牌精简信息查询Controller
 */
@Tag(name = "商品品牌管理", description = "商品品牌精简信息查询接口")
@RestController
@RequestMapping("/product/brand/list-all-simple")
@RequiredArgsConstructor
@Validated
public class ProductBrandListAllSimpleController {

    private final ProductBrandListAllSimpleService productBrandListAllSimpleService;

    @Operation(summary = "查询品牌精简信息列表", description = "查询品牌精简信息列表，主要用于前端的下拉选项")
    @GetMapping
    public CommonResult<List<ProductBrandListAllSimpleRespVO>> getBrandSimpleList() {
        List<ProductBrandListAllSimpleRespVO> respVOList = productBrandListAllSimpleService.getBrandSimpleList();
        return CommonResult.success(respVOList);
    }
}