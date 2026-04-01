package com.github.wenhao.product.property.page.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageReqVO;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageRespVO;
import com.github.wenhao.product.property.page.service.ProductPropertyPageService;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品属性项分页查询Controller
 */
@Tag(name = "商品属性项管理", description = "商品属性项分页查询接口")
@RestController
@RequestMapping("/product/property/page")
@RequiredArgsConstructor
@Validated
public class ProductPropertyPageController {

    private final ProductPropertyPageService productPropertyPageService;

    @Operation(summary = "分页查询商品属性项", description = "根据属性项名称、创建时间分页查询商品属性项")
    @GetMapping
    public CommonResult<IPage<ProductPropertyPageRespVO>> getPropertyPage(@ModelAttribute ProductPropertyPageReqVO reqVO) {
        IPage<ProductPropertyPageRespVO> respVO = productPropertyPageService.getPropertyPage(reqVO);
        return CommonResult.success(respVO);
    }
}