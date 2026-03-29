package com.github.product.controller;

import com.github.product.common.pojo.ResponseResult;
import com.github.product.controller.vo.GetProductCategoryListReqVO;
import com.github.product.controller.vo.GetProductCategoryListRespVO;
import com.github.product.service.ProductCategoryListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 独立的商品分类_查询列表controller类，ProductCategoryListController。
 */
@Tag(name = "商品分类_查询列表")
@RestController
@RequestMapping("/product/category")
public class ProductCategoryListController {

    @Resource
    private ProductCategoryListService productCategoryListService;

    /**
     * 查询商品分类列表
     *
     * @param parentId 父分类编号
     * @param name 分类名称
     * @param status 开启状态
     * @return ResponseResult<List<GetProductCategoryListRespVO>>
     */
    @Operation(summary = "查询商品分类列表", description = "根据条件查询商品分类列表信息，支持按父分类编号、分类名称、开启状态筛选")
    @GetMapping("/list")
    public ResponseResult<List<GetProductCategoryListRespVO>> getProductCategoryList(
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer status) {
        
        GetProductCategoryListReqVO reqVO = new GetProductCategoryListReqVO();
        reqVO.setParentId(parentId);
        reqVO.setName(name);
        reqVO.setStatus(status);
        
        List<GetProductCategoryListRespVO> respVOList = productCategoryListService.getProductCategoryList(reqVO);
        return ResponseResult.success(respVOList);
    }
}