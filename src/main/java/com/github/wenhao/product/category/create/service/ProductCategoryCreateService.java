package com.github.wenhao.product.category.create.service;

import com.github.wenhao.product.category.create.mapper.ProductCategoryCreateMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.category.create.controller.vo.CreateProductCategoryReqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCategoryCreateService {

    private final ProductCategoryCreateMapper productCategoryCreateMapper;

    @Transactional
    public Long createProductCategory(CreateProductCategoryReqVO reqVO) {
        // 参数校验：若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (reqVO.getParentId() != null && !reqVO.getParentId().equals(0L)) {
            // 参数校验：根据传入的创建商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在
            ProductCategory parentCategory = productCategoryCreateMapper.selectById(reqVO.getParentId());
            if (parentCategory == null) {
                throw new RuntimeException("父分类不存在，错误码：1_008_001_001");
            }
            
            // 参数校验：根据传入的创建商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L）
            if (!parentCategory.getParentId().equals(0L)) {
                throw new RuntimeException("父分类不能是二级分类，错误码：1_008_001_002");
            }
        }
        
        // 数据转换：将传入的创建商品分类-请求参数(Body)，转换为数据库对应的商品分类(entity)数据对象
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(reqVO.getParentId());
        productCategory.setName(reqVO.getName());
        productCategory.setPicUrl(reqVO.getPicUrl());
        productCategory.setSort(reqVO.getSort());
        productCategory.setStatus(reqVO.getStatus());

        // 数据库操作：使用商品分类_创建(mapper)的数据库操作对象将商品分类(entity)数据对象插入数据库
        productCategoryCreateMapper.insert(productCategory);

        // 方法返回：返回数据库自动生成的商品商品分类(entity)-分类编号
        return productCategory.getId();
    }
}