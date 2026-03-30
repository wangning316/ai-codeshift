package com.github.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.product.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_创建(mapper)
 * 
 * 独立的商品分类_创建mapper类, ProductCategoryCreateMapper
 */
@Mapper
public interface ProductCategoryCreateMapper extends BaseMapper<ProductCategory> {
    
}