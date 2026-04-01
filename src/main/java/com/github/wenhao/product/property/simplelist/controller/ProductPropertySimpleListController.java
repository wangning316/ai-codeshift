package com.github.wenhao.product.property.simplelist.controller;

import com.github.wenhao.product.common.pojo.CommonResult;
import com.github.wenhao.product.property.simplelist.controller.vo.ProductPropertySimpleListRespVO;
import com.github.wenhao.product.property.simplelist.service.ProductPropertySimpleListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品属性项_查询属性项精简列表Controller
 */
@Tag(name = "商品属性管理", description = "商品属性项_查询属性项精简列表接口")
@RestController
@RequestMapping("/product/brand/simple-list")
@RequiredArgsConstructor
@Validated
public class ProductPropertySimpleListController {

    private final ProductPropertySimpleListService productPropertySimpleListService;

    @Operation(summary = "查询属性项精简列表", description = "查询商品属性项精简列表")
    @GetMapping
    public CommonResult<List<ProductPropertySimpleListRespVO>> getPropertySimpleList() {
        List<ProductPropertySimpleListRespVO> respVOList = productPropertySimpleListService.getPropertySimpleList();
        return CommonResult.success(respVOList);
    }
}