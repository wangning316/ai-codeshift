package com.github.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.product.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_创建(mapper)
 * 
 * 独立的商品分类_创建mapper类, ProductCategoryCreateMapper。
 * 
 * 方法描述:
 * - 根据商品分类(entity)插入数据库。
 */
@Mapper
public interface ProductCategoryCreateMapper extends BaseMapper<ProductCategory> {
    
}