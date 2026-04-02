package com.github.wenhao.product.spu.list.controller;

import com.github.wenhao.product.common.pojo.CommonResult;
import com.github.wenhao.product.spu.list.controller.vo.ProductSpuListReqVO;
import com.github.wenhao.product.spu.list.controller.vo.ProductSpuListRespVO;
import com.github.wenhao.product.spu.list.service.ProductSpuListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品SPU列表查询Controller
 */
@Tag(name = "商品SPU管理", description = "商品SPU列表查询接口")
@RestController
@RequestMapping("/product/spu/list")
@RequiredArgsConstructor
@Validated
public class ProductSpuListController {

    private final ProductSpuListService productSpuListService;

    @Operation(summary = "查询商品SPU列表", description = "根据SPU编号列表查询商品SPU列表")
    @GetMapping
    public CommonResult<List<ProductSpuListRespVO>> getSpuList(ProductSpuListReqVO reqVO) {
        List<ProductSpuListRespVO> respVOList = productSpuListService.getSpuList(reqVO.getSpuIds());
        return CommonResult.success(respVOList);
    }
}