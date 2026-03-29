package com.company.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.project.entity.po.ProductCategory;
import com.company.project.exception.BusinessException;
import com.company.project.mapper.ProductCategoryDeleteMapper;
import com.company.project.service.ProductCategoryDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryDeleteServiceImpl implements ProductCategoryDeleteService {

    private final ProductCategoryDeleteMapper productCategoryDeleteMapper;

    @Override
    public Boolean deleteProductCategory(Long id) {
        // 参数校验：根据传入的商品分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验商品分类是否真实存在
        ProductCategory category = productCategoryDeleteMapper.selectById(id);
        if (category == null) {
            throw new BusinessException("1_008_002_001", "商品分类不存在");
        }

        // 参数校验：根据传入的商品分类编号查询其是否存在子分类
        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        List<ProductCategory> childCategories = productCategoryDeleteMapper.selectList(queryWrapper);
        if (!childCategories.isEmpty()) {
            throw new BusinessException("1_008_002_002", "存在子分类，无法删除");
        }

        // 数据库操作：使用商品分类_删除(mapper)的数据库操作对象根据商品分类编号进行逻辑删除操作
        int result = productCategoryDeleteMapper.deleteById(id);

        // 方法返回：返回删除结果，true表示删除成功
        return result > 0;
    }
}