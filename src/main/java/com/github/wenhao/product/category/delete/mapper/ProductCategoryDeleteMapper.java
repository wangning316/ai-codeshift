package com.github.wenhao.product.category.delete.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类_删除(mapper)
 *
 * 根据`分类编号`从数据库查询`商品分类(entity)`
 * 根据`分类编号`从数据库删除`商品分类(entity)`
 */
@Mapper
public interface ProductCategoryDeleteMapper extends BaseMapper<ProductCategory> {

}