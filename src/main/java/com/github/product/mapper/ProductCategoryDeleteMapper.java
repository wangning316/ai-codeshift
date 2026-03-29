package com.github.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.product.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_删除(mapper)
 * 
 * 独立的商品分类_删除mapper类, ProductCategoryDeleteMapper。
 * 
 * 方法描述:
 * - 根据商品分类编号删除商品分类。
 */
@Mapper
public interface ProductCategoryDeleteMapper extends BaseMapper<ProductCategory> {
    
}