package com.github.wenhao.product.category.create.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.category.create.mapper.ProductCategoryCreateMapper;
import com.github.wenhao.product.category.create.service.ProductCategoryCreateService;
import com.github.wenhao.product.category.create.vo.ProductCategoryCreateReqVO;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 商品分类创建Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryCreateServiceImpl implements ProductCategoryCreateService {

    private static final Long ROOT_PARENT_ID = 0L;

    private final ProductCategoryCreateMapper productCategoryCreateMapper;

    @Override
    public Long createCategory(ProductCategoryCreateReqVO createReqVO) {
        // 2. 参数校验：若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (!ROOT_PARENT_ID.equals(createReqVO.getParentId())) {
            // 3. 参数校验：根据父分类编号查询数据库校验父分类是否真实存在
            ProductCategory parentCategory = productCategoryCreateMapper.selectOne(
                new LambdaQueryWrapper<ProductCategory>()
                    .eq(ProductCategory::getId, createReqVO.getParentId())
            );
            if (parentCategory == null) {
                throw new BusinessException("1_008_001_001", "父分类不存在");
            }

            // 4. 参数校验：父分类必须是一级分类（值为0L）
            if (!ROOT_PARENT_ID.equals(parentCategory.getParentId())) {
                throw new BusinessException("1_008_001_002", "父分类不能是二级分类");
            }
        }

        // 5. 数据转换：将请求参数转换为数据库实体对象
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(createReqVO, productCategory);

        // 6. 数据库操作：插入数据库
        productCategoryCreateMapper.insert(productCategory);

        // 7. 方法返回：返回数据库自动生成的商品分类编号
        return productCategory.getId();
    }
}