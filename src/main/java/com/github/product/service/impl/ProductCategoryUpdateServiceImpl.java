package com.github.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.product.entity.po.ProductCategory;
import com.github.product.exception.BusinessException;
import com.github.product.controller.vo.UpdateProductCategoryReqVO;
import com.github.product.mapper.ProductCategoryUpdateMapper;
import com.github.product.service.ProductCategoryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 商品分类_更新服务实现类
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryUpdateServiceImpl extends ServiceImpl<ProductCategoryUpdateMapper, ProductCategory> implements ProductCategoryUpdateService {

    private final ProductCategoryUpdateMapper productCategoryUpdateMapper;

    /**
     * 更新商品分类
     */
    @Override
    public Boolean updateProductCategory(UpdateProductCategoryReqVO reqVO) {
        // 1. 参数校验：根据传入的`更新商品分类-请求参数(Body)-分类编号`使用`商品分类(mapper)`的数据库操作对象查询数据库校验分类编号是否真实存在
        ProductCategory existingCategory = productCategoryUpdateMapper.selectById(reqVO.getId());
        if (existingCategory == null) {
            throw new BusinessException("1_008_001_000", "商品分类不存在");
        }

        // 2. 参数校验：若传入的`更新商品分类-请求参数(Body)-父分类编号`为根分类默认标识（值为0L），直接跳过校验
        if (!reqVO.getParentId().equals(0L)) {
            // 3. 参数校验：根据传入的`更新商品分类-请求参数(Body)-父分类编号`不为根分类则使用`商品分类_更新(mapper)`的数据库操作对象查询数据库校验父分类编号是否真实存在
            ProductCategory parentCategory = productCategoryUpdateMapper.selectById(reqVO.getParentId());
            if (parentCategory == null) {
                throw new BusinessException("1_008_001_001", "父分类不存在");
            }
            
            // 4. 若存在但其父分类不为根分类默认标识（值为0L）则抛出"父分类不能是二级分类"业务异常
            if (!parentCategory.getParentId().equals(0L)) {
                throw new BusinessException("1_008_001_002", "父分类不能是二级分类");
            }
        }

        // 5. 数据转换：将传入的`更新商品分类-请求参数(Body)`，转换为数据库对应的`商品分类(entity)`数据对象
        ProductCategory categoryToUpdate = new ProductCategory();
        categoryToUpdate.setId(reqVO.getId());
        categoryToUpdate.setParentId(reqVO.getParentId());
        categoryToUpdate.setName(reqVO.getName());
        categoryToUpdate.setPicUrl(reqVO.getPicUrl());
        categoryToUpdate.setSort(reqVO.getSort());
        categoryToUpdate.setStatus(reqVO.getStatus());
        categoryToUpdate.setDescription(reqVO.getDescription());
        categoryToUpdate.setUpdateTime(java.time.LocalDateTime.now());

        // 6. 数据库操作：使用`商品分类_更新(mapper)`的数据库操作对象将`商品分类(entity)`数据对象更新数据库
        int result = productCategoryUpdateMapper.updateById(categoryToUpdate);
        
        return result > 0;
    }
}