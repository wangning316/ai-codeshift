package com.github.wenhao.product.category.create.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductCategoryCreateMapper extends BaseMapper<ProductCategory> {
    // 根据商品分类entity插入数据库
    
    /**
     * 根据ID查询商品分类
     */
    @Select("SELECT * FROM product_category WHERE id = #{id} AND deleted = 0")
    ProductCategory selectById(Long id);
}