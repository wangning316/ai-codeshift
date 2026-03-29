package com.github.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.product.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_查询(mapper)
 * 根据`分类编号`从数据库查询`商品分类(entity)`
 */
@Mapper
public interface ProductCategoryGetMapper extends BaseMapper<ProductCategory> {
}