package com.github.wenhao.product.history.page.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageReqVO;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageRespVO;
import com.github.wenhao.product.history.page.service.ProductBrowseHistoryPageService;
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
 * 商品浏览记录分页查询Controller
 */
@Tag(name = "商品浏览记录管理", description = "商品浏览记录分页查询接口")
@RestController
@RequestMapping("/product/browse-history/page")
@RequiredArgsConstructor
@Validated
public class ProductBrowseHistoryPageController {

    private final ProductBrowseHistoryPageService productBrowseHistoryPageService;

    @Operation(summary = "分页查询商品浏览记录", description = "根据用户编号分页查询商品浏览记录")
    @GetMapping
    public CommonResult<IPage<ProductBrowseHistoryPageRespVO>> getBrowseHistoryPage(@ModelAttribute ProductBrowseHistoryPageReqVO reqVO) {
        IPage<ProductBrowseHistoryPageRespVO> respVO = productBrowseHistoryPageService.getBrowseHistoryPage(reqVO);
        return CommonResult.success(respVO);
    }
}