package com.github.wenhao.product.property.page.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.property.entity.po.ProductProperty;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性项分页Mapper
 */
@Mapper
public interface ProductPropertyPageMapper extends BaseMapper<ProductProperty> {

}