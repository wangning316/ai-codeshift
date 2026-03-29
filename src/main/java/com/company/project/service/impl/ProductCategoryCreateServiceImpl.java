package com.company.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.entity.po.ProductCategory;
import com.company.project.exception.BusinessException;
import com.company.project.mapper.ProductCategoryCreateMapper;
import com.company.project.service.ProductCategoryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductCategoryCreateServiceImpl implements ProductCategoryCreateService {

    private final ProductCategoryCreateMapper productCategoryCreateMapper;

    @Override
    public Long createProductCategory(Long parentId, String name, String picUrl, Integer sort, Integer status, String description) {
        // 参数校验：若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (parentId != null && !parentId.equals(0L)) {
            // 参数校验：根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在
            QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", parentId);
            ProductCategory parentCategory = productCategoryCreateMapper.selectOne(queryWrapper);
            if (parentCategory == null) {
                throw new BusinessException("1_008_001_001", "父分类不存在");
            }

            // 参数校验：根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L）
            if (!parentCategory.getParentId().equals(0L)) {
                throw new BusinessException("1_008_001_002", "父分类不能是二级分类");
            }
        }

        // 数据转换：将传入的参数，转换为数据库对应的商品分类(entity)数据对象
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentId);
        productCategory.setName(name);
        productCategory.setPicUrl(picUrl);
        productCategory.setSort(sort);
        productCategory.setStatus(status);
        productCategory.setDescription(description);

        // 设置创建时间和更新时间为当前时间
        productCategory.setCreateTime(LocalDateTime.now());
        productCategory.setUpdateTime(LocalDateTime.now());

        // 数据库操作：使用商品分类_创建(mapper)的数据库操作对象将商品分类(entity)数据对象插入数据库
        productCategoryCreateMapper.insert(productCategory);

        // 方法返回：返回数据库自动生成的商品商品分类(entity)-分类编号
        return productCategory.getId();
    }
}