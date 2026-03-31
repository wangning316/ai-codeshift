package com.github.wenhao.product.category.update.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.category.update.mapper.ProductCategoryUpdateMapper;
import com.github.wenhao.product.category.update.service.ProductCategoryUpdateService;
import com.github.wenhao.product.category.update.vo.ProductCategoryUpdateReqVO;
import com.github.wenhao.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 商品分类更新Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryUpdateServiceImpl implements ProductCategoryUpdateService {

    private static final Long ROOT_PARENT_ID = 0L;

    private final ProductCategoryUpdateMapper productCategoryUpdateMapper;

    @Override
    public Boolean updateCategory(ProductCategoryUpdateReqVO updateReqVO) {
        // 2. 参数校验：根据分类编号查询数据库校验分类是否真实存在
        ProductCategory category = productCategoryUpdateMapper.selectOne(
            new LambdaQueryWrapper<ProductCategory>()
                .eq(ProductCategory::getId, updateReqVO.getId())
        );
        if (category == null) {
            throw new BusinessException("1_008_001_000", "商品分类不存在");
        }

        // 3. 参数校验：若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (!ROOT_PARENT_ID.equals(updateReqVO.getParentId())) {
            // 4. 参数校验：根据父分类编号查询数据库校验父分类是否真实存在
            ProductCategory parentCategory = productCategoryUpdateMapper.selectOne(
                new LambdaQueryWrapper<ProductCategory>()
                    .eq(ProductCategory::getId, updateReqVO.getParentId())
            );
            if (parentCategory == null) {
                throw new BusinessException("1_008_001_001", "父分类不存在");
            }

            // 若存在但其父分类不为根分类默认标识则抛出"父分类不能是二级分类"
            if (!ROOT_PARENT_ID.equals(parentCategory.getParentId())) {
                throw new BusinessException("1_008_001_002", "父分类不能是二级分类");
            }
        }

        // 5. 数据转换：将请求参数转换为数据库实体对象
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(updateReqVO, productCategory);

        // 6. 数据库操作：更新数据库
        productCategoryUpdateMapper.updateById(productCategory);

        return true;
    }
}