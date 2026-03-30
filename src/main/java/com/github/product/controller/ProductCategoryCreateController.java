package com.github.product.controller;

import com.github.product.common.Result;
import com.github.product.dto.ProductCategoryCreateReqDTO;
import com.github.product.service.ProductCategoryCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品分类_创建(controller)
 * 
 * 独立的商品分类_创建controller类，ProductCategoryCreateController
 */
@RestController
@RequestMapping("/product/category")
@Tag(name = "商品分类_创建", description = "创建商品分类")
@RequiredArgsConstructor
public class ProductCategoryCreateController {

    private final ProductCategoryCreateService productCategoryCreateService;

    /**
     * 创建商品分类
     * 
     * 接口描述：创建商品分类
     * 请求地址：POST /product/category/create
     * 请求方法：POST
     * 
     * 请求参数(Body):
     * - parentId: 父分类编号，Long类型，必填，仅非空校验，校验不通过提示：父分类编号不能为空
     * - name: 分类名称，String类型，必填，仅非空校验，校验不通过提示：分类名称不能为空
     * - picUrl: 移动端分类图，String类型，必填，仅非空校验，校验不通过提示：移动端分类图不能为空
     * - sort: 分类排序，Integer类型，必填，无额外注解校验
     * - status: 开启状态，Integer类型，必填，仅非空校验，校验不通过提示：开启状态不能为空
     * - description: 分类描述，String类型，选填
     * 
     * 响应参数:
     * - code: 响应码，int类型，200=成功
     * - msg: 响应信息，String类型
     * - data: 创建成功的商品分类编号，Long类型
     */
    @PostMapping("/create")
    @Operation(summary = "创建商品分类", description = "创建商品分类")
    public Result<Long> createProductCategory(@RequestBody @Valid ProductCategoryCreateReqDTO reqDTO) {
        Long categoryId = productCategoryCreateService.createProductCategory(reqDTO);
        return Result.success(categoryId);
    }
}