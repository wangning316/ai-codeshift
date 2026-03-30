package com.github.wenhao.product.category.delete.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    public Boolean deleteProductCategory(Long id) {
        // 参数校验：根据传入的删除商品分类-请求参数（Query）-分类编号使用商品分类(mapper)_删除的数据库操作对象查询数据库校验待删除的分类编号是否真实存在，若不存在则抛出"商品分类不存在"业务异常，错误码：1_008_001_000
        ProductCategory category = productCategoryDeleteMapper.selectById(id);
        if (category == null) {
            throw new RuntimeException("商品分类不存在，错误码：1_008_001_000");
        }

        // 参数校验：根据传入的删除商品分类-请求参数（Query）-分类编号使用商品分类(mapper)_删除的数据库操作对象查询数据库校验该分类是否有子分类，若还有子分类则抛出"存在子分类，无法删除"业务异常，错误码：1_008_001_003
        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductCategory::getParentId, id);
        queryWrapper.eq(ProductCategory::getDeleted, false);
        Long childCount = productCategoryDeleteMapper.selectCount(queryWrapper);
        if (childCount > 0) {
            throw new RuntimeException("存在子分类，无法删除，错误码：1_008_001_003");
        }

        // 数据库操作：使用商品分类_删除(mapper)的数据库操作对象将分类编号数据对象从数据库删除
        int deletedRows = productCategoryDeleteMapper.deleteById(id);
        
        return deletedRows > 0;
    }
}