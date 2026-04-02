package com.github.wenhao.product.comment.updatevisible.controller;

import com.github.wenhao.product.comment.updatevisible.service.ProductCommentVisibleService;
import com.github.wenhao.product.comment.updatevisible.vo.ProductCommentUpdateVisibleReqVO;
import com.github.wenhao.product.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品评价更新可见性Controller
 */
@Tag(name = "商品评价管理", description = "商品评价更新可见性接口")
@RestController
@RequestMapping("/product/comment/update-visible")
@RequiredArgsConstructor
@Validated
public class ProductCommentVisibleController {

    private final ProductCommentVisibleService productCommentVisibleService;

    @Operation(summary = "更新商品评价可见性", description = "更新商品评价的可见性状态")
    @PutMapping
    public CommonResult<Boolean> updateCommentVisible(@Valid @RequestBody ProductCommentUpdateVisibleReqVO updateVisibleReqVO) {
        Boolean result = productCommentVisibleService.updateCommentVisible(updateVisibleReqVO);
        return CommonResult.success(result);
    }
}