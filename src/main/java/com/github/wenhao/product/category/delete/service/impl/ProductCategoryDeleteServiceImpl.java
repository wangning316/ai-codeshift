package com.github.wenhao.product.category.delete.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.category.delete.mapper.ProductCategoryDeleteMapper;
import com.github.wenhao.product.category.delete.service.ProductCategoryDeleteService;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 商品分类删除Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryDeleteServiceImpl implements ProductCategoryDeleteService {

    private final ProductCategoryDeleteMapper productCategoryDeleteMapper;

    @Override
    public Boolean deleteCategory(Long id) {
        // 1. 参数校验：根据分类编号查询数据库校验分类是否真实存在
        ProductCategory category = productCategoryDeleteMapper.selectOne(
            new LambdaQueryWrapper<ProductCategory>()
                .eq(ProductCategory::getId, id)
        );
        if (category == null) {
            throw new BusinessException("1_008_001_000", "商品分类不存在");
        }

        // 2. 参数校验：查询是否有子分类
        Long childCount = productCategoryDeleteMapper.selectCount(
            new LambdaQueryWrapper<ProductCategory>()
                .eq(ProductCategory::getParentId, id)
        );
        if (childCount > 0) {
            throw new BusinessException("1_008_001_003", "存在子分类，无法删除");
        }

        // 3. 参数校验：查询该分类下是否有SPU
        int spuCount = productCategoryDeleteMapper.countSpuByCategoryId(id);
        if (spuCount > 0) {
            throw new BusinessException("1_008_001_005", "类别下存在商品，无法删除");
        }

        // 4. 数据库操作：将分类编号数据对象从数据库删除
        productCategoryDeleteMapper.deleteById(id);

        return true;
    }
}