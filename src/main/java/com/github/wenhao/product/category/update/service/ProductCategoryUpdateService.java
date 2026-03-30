package com.github.wenhao.product.category.update.service;

import com.github.wenhao.product.category.update.mapper.ProductCategoryUpdateMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.category.update.controller.vo.UpdateProductCategoryReqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCategoryUpdateService {

    private final ProductCategoryUpdateMapper productCategoryUpdateMapper;

    @Transactional
    public void updateProductCategory(UpdateProductCategoryReqVO reqVO) {
        // 根据传入的分类编号查询数据库获取原分类信息
        ProductCategory productCategory = productCategoryUpdateMapper.selectById(reqVO.getId());
        if (productCategory == null) {
            throw new RuntimeException("分类不存在，错误码：1_008_002_001");
        }

        // 参数校验：若传入的父分类编号不为根分类默认标识（值为0L），则需校验父分类是否存在
        if (reqVO.getParentId() != null && !reqVO.getParentId().equals(0L)) {
            // 参数校验：根据传入的更新商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在
            ProductCategory parentCategory = productCategoryUpdateMapper.selectById(reqVO.getParentId());
            if (parentCategory == null) {
                throw new RuntimeException("父分类不存在，错误码：1_008_002_002");
            }

            // 参数校验：根据传入的更新商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L）
            if (!parentCategory.getParentId().equals(0L)) {
                throw new RuntimeException("父分类不能是二级分类，错误码：1_008_002_003");
            }
        }

        // 更新商品分类信息
        productCategory.setParentId(reqVO.getParentId());
        productCategory.setName(reqVO.getName());
        productCategory.setPicUrl(reqVO.getPicUrl());
        productCategory.setSort(reqVO.getSort());
        productCategory.setStatus(reqVO.getStatus());

        // 数据库操作：使用商品分类_更新(mapper)的数据库操作对象更新数据库中的商品分类信息
        productCategoryUpdateMapper.updateById(productCategory);
    }
}