package com.github.wenhao.product.history.page.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品SPU批量查询Mapper（用于浏览记录）
 */
@Mapper
public interface ProductSpuBatchListForBrowseHistoryMapper extends BaseMapper<ProductSpu> {

    /**
     * 根据商品SPU编号列表查询所有商品SPU数据
     *
     * @param spuIds 商品SPU编号列表
     * @return 商品SPU列表
     */
    @Select("<script>" +
            "SELECT * FROM product_spu WHERE id IN " +
            "<foreach collection='spuIds' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            " AND deleted = 0" +
            "</script>")
    List<ProductSpu> selectBySpuIds(@Param("spuIds") List<Long> spuIds);
}