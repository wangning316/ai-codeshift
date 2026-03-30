package com.github.wenhao.product.category.delete.service;

import com.github.wenhao.product.category.delete.mapper.ProductCategoryDeleteMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCategoryDeleteService {

    private final ProductCategoryDeleteMapper productCategoryDeleteMapper;

    @Transactional
    public void deleteProductCategory(Long id) {
        // 参数校验：根据传入的删除商品分类-请求参数(Body)-分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验分类是否真实存在
        ProductCategory category = productCategoryDeleteMapper.selectById(id);
        if (category == null) {
            throw new RuntimeException("商品分类不存在，错误码：1_008_002_001");
        }

        // 参数校验：检查是否存在子分类，如果存在则不允许删除
        int childCount = productCategoryDeleteMapper.selectCount(
            wrapper -> wrapper.eq("parent_id", id).eq("deleted", 0)
        );
        if (childCount > 0) {
            throw new RuntimeException("存在子分类，无法删除，请先删除子分类，错误码：1_008_002_002");
        }

        // 数据库操作：使用商品分类_删除(mapper)的数据库操作对象根据分类编号逻辑删除数据库中的商品分类
        productCategoryDeleteMapper.deleteById(id);
    }
}