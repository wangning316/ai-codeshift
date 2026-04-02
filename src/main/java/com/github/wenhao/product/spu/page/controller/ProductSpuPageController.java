package com.github.wenhao.product.spu.page.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.common.pojo.CommonResult;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageReqVO;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageRespVO;
import com.github.wenhao.product.spu.page.service.ProductSpuPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品SPU分页查询Controller
 */
@Tag(name = "商品SPU管理", description = "商品SPU分页查询接口")
@RestController
@RequestMapping("/product/spu/page")
@RequiredArgsConstructor
@Validated
public class ProductSpuPageController {

    private final ProductSpuPageService productSpuPageService;

    @Operation(summary = "分页查询商品SPU", description = "根据商品名称、分类、状态、创建时间分页查询商品SPU")
    @GetMapping
    public CommonResult<IPage<ProductSpuPageRespVO>> getSpuPage(@ModelAttribute ProductSpuPageReqVO reqVO) {
        IPage<ProductSpuPageRespVO> respVO = productSpuPageService.getSpuPage(reqVO);
        return CommonResult.success(respVO);
    }
}