package com.github.wenhao.product.category.get.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.category.get.mapper.ProductCategoryGetMapper;
import com.github.wenhao.product.category.get.controller.vo.ProductCategoryGetRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCategoryGetService {

    private final ProductCategoryGetMapper productCategoryGetMapper;

    /**
     * 查询商品分类
     */
    public ProductCategoryGetRespVO getProductCategory(Long id) {
        // 数据库操作：根据分类编号查询商品分类
        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductCategory::getId, id);
        queryWrapper.eq(ProductCategory::getDeleted, false); // 只查询未删除的数据

        ProductCategory productCategory = productCategoryGetMapper.selectOne(queryWrapper);
        if (productCategory == null) {
            return null;
        }

        // 数据转换：将数据库查询的商品分类转换为响应对象
        ProductCategoryGetRespVO respVO = new ProductCategoryGetRespVO();
        BeanUtils.copyProperties(productCategory, respVO);
        return respVO;
    }
}