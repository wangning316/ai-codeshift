package com.github.wenhao.product.category.get.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryGetMapper extends BaseMapper<ProductCategory> {
}