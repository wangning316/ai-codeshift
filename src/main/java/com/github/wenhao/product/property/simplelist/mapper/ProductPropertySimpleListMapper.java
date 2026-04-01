package com.github.wenhao.product.property.simplelist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.property.entity.po.ProductProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性项_询属性项精简列表Mapper
 */
@Mapper
public interface ProductPropertySimpleListMapper extends BaseMapper<ProductProperty> {

    /**
     * 从数据库查询所有商品属性项列表
     *
     * @return 商品属性项列表
     */
    List<ProductProperty> selectList();
}