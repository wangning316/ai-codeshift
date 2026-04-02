package com.github.wenhao.product.category.delete.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.category.entity.po.ProductCategory;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductCategoryDeleteMapper extends BaseMapper<ProductCategory> {

    /**
     * 根据分类编号查询商品SPU数量
     *
     * @param categoryId 分类编号
     * @return 商品SPU数量
     */
    @Select("SELECT COUNT(*) FROM product_spu WHERE category_id = #{categoryId} AND deleted = 0")
    int countSpuByCategoryId(@Param("categoryId") Long categoryId);
}