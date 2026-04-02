package com.github.wenhao.product.spu.get.controller;

import com.github.wenhao.product.common.pojo.CommonResult;
import com.github.wenhao.product.spu.get.controller.vo.ProductSpuGetDetailReqVO;
import com.github.wenhao.product.spu.get.controller.vo.ProductSpuGetDetailRespVO;
import com.github.wenhao.product.spu.get.service.ProductSpuGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品SPU查询Controller
 */
@Tag(name = "商品SPU管理", description = "商品SPU查询接口")
@RestController
@RequestMapping("/product/spu/get-detail")
@RequiredArgsConstructor
@Validated
public class ProductSpuGetController {

    private final ProductSpuGetService productSpuGetService;

    @Operation(summary = "查询商品SPU明细", description = "根据商品SPU编号查询商品SPU明细（包含关联SKU列表）")
    @GetMapping
    public CommonResult<ProductSpuGetDetailRespVO> getSpuDetail(@Valid ProductSpuGetDetailReqVO reqVO) {
        ProductSpuGetDetailRespVO respVO = productSpuGetService.getSpuDetail(reqVO.getId());
        return CommonResult.success(respVO);
    }
}