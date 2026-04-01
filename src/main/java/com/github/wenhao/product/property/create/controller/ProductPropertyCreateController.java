package com.github.wenhao.product.property.create.controller;

import com.github.wenhao.product.common.pojo.CommonResult;
import com.github.wenhao.product.property.create.service.ProductPropertyCreateService;
import com.github.wenhao.product.property.create.vo.ProductPropertyCreateReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品属性项创建Controller
 */
@Tag(name = "商品属性项管理", description = "商品属性项创建接口")
@RestController
@RequestMapping("/product/property/create")
@RequiredArgsConstructor
@Validated
public class ProductPropertyCreateController {

    private final ProductPropertyCreateService productPropertyCreateService;

    @Operation(summary = "创建商品属性项", description = "创建新的商品属性项")
    @PostMapping
    public CommonResult<Long> createProperty(@Valid @RequestBody ProductPropertyCreateReqVO createReqVO) {
        Long propertyId = productPropertyCreateService.createProperty(createReqVO);
        return CommonResult.success("创建成功", propertyId);
    }
}