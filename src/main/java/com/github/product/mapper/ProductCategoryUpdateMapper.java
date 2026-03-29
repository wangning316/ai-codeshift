package com.github.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.product.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_更新(mapper)
 *
 * 独立的商品分类_更新mapper类, ProductCategoryUpdateMapper。
 */
@Mapper
public interface ProductCategoryUpdateMapper extends BaseMapper<ProductCategory> {
    // 继承BaseMapper即可获得基本的CRUD操作
    // MyBatis-Plus会自动生成基本的SQL语句
}