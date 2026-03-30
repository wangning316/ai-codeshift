package com.github.wenhao.product.category.list.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.category.list.mapper.ProductCategoryListMapper;
import com.github.wenhao.product.category.list.controller.vo.ProductCategoryListReqVO;
import com.github.wenhao.product.category.list.controller.vo.ProductCategoryListRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryListService {

    private final ProductCategoryListMapper productCategoryListMapper;

    /**
     * 查询商品分类列表
     */
    public List<ProductCategoryListRespVO> listProductCategories(ProductCategoryListReqVO reqVO) {
        // 构建查询条件
        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductCategory::getDeleted, false); // 只查询未删除的数据

        // 根据请求参数添加查询条件
        if (reqVO != null) {
            if (reqVO.getName() != null && !reqVO.getName().isEmpty()) {
                queryWrapper.like(ProductCategory::getName, reqVO.getName());
            }
            if (reqVO.getStatus() != null) {
                queryWrapper.eq(ProductCategory::getStatus, reqVO.getStatus());
            }
            if (reqVO.getParentId() != null) {
                queryWrapper.eq(ProductCategory::getParentId, reqVO.getParentId());
            }
            if (reqVO.getParentIds() != null && !reqVO.getParentIds().isEmpty()) {
                queryWrapper.in(ProductCategory::getParentId, reqVO.getParentIds());
            }
        }

        // 按排序字段升序排列
        queryWrapper.orderByAsc(ProductCategory::getSort);

        // 执行查询
        List<ProductCategory> productCategories = productCategoryListMapper.selectList(queryWrapper);

        // 将实体对象转换为响应对象
        return productCategories.stream()
                .map(this::convertToProductCategoryListRespVO)
                .collect(Collectors.toList());
    }

    private ProductCategoryListRespVO convertToProductCategoryListRespVO(ProductCategory productCategory) {
        ProductCategoryListRespVO respVO = new ProductCategoryListRespVO();
        BeanUtils.copyProperties(productCategory, respVO);
        return respVO;
    }
}