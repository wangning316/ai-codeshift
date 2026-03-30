package com.github.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.product.dto.ProductCategoryCreateReqDTO;
import com.github.product.entity.ProductCategory;
import com.github.product.mapper.ProductCategoryCreateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * 商品分类_创建(service)
 * 
 * 独立的商品分类_创建service类，ProductCategoryCreateService
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryCreateService {

    private final ProductCategoryCreateMapper productCategoryCreateMapper;

    /**
     * 创建商品分类
     * 
     * 业务逻辑：
     * 1. 传入`创建商品分类-请求参数(Body)`对象。
     * 2. 参数校验：若传入的`创建商品分类-请求参数(Body)-父分类编号`为根分类默认标识（值为0L），直接跳过校验。
     * 3. 参数校验：根据传入的`创建商品分类-请求参数(Body)-父分类编号`使用`商品分类(mapper)`的数据库操作对象查询数据库校验父分类是否真实存在，若不存在则抛出"父分类不存在"业务异常，错误码：1_008_001_001；
     * 4. 参数校验：根据传入的`创建商品分类-请求参数(Body)-父分类编号`使用`商品分类(mapper)`的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L），若父分类为二级及以下层级，抛出"父分类不能是二级分类"业务异常，错误码：1_008_001_002。
     * 5. 数据转换：将传入的`创建商品分类-请求参数(Body)`，转换为数据库对应的`商品分类(entity)`数据对象。
     * 6. 数据库操作：使用`商品分类_创建(mapper)`的数据库操作对象将`商品分类(entity)`数据对象插入数据库。
     * 7. 方法返回：返回数据库自动生成的商品`商品分类(entity)-分类编号`。
     */
    public Long createProductCategory(ProductCategoryCreateReqDTO reqDTO) {
        // 参数校验：若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (reqDTO.getParentId() != null && !reqDTO.getParentId().equals(0L)) {
            // 参数校验：根据传入的父分类编号查询数据库校验父分类是否真实存在
            QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", reqDTO.getParentId());
            ProductCategory parentCategory = productCategoryCreateMapper.selectOne(queryWrapper);
            if (parentCategory == null) {
                throw new RuntimeException("父分类不存在"); // 错误码：1_008_001_001
            }
            
            // 参数校验：校验父分类必须是一级分类（值为0L），若父分类为二级及以下层级，抛出"父分类不能是二级分类"业务异常
            if (!parentCategory.getParentId().equals(0L)) {
                throw new RuntimeException("父分类不能是二级分类"); // 错误码：1_008_001_002
            }
        }

        // 数据转换：将传入的请求参数，转换为数据库对应的实体数据对象
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(reqDTO.getParentId());
        productCategory.setName(reqDTO.getName());
        productCategory.setPicUrl(reqDTO.getPicUrl());
        productCategory.setSort(reqDTO.getSort());
        productCategory.setStatus(reqDTO.getStatus());
        productCategory.setDescription(reqDTO.getDescription());

        // 数据库操作：使用mapper的数据库操作对象将实体数据对象插入数据库
        productCategoryCreateMapper.insert(productCategory);

        // 方法返回：返回数据库自动生成的商品分类编号
        return productCategory.getId();
    }
}