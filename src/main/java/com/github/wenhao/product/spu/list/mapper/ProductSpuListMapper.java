package com.github.wenhao.product.spu.list.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.spu.entity.po.ProductSku;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ProductSpuListMapper extends BaseMapper<ProductSpu> {

    /**
     * 根据SPU编号列表查询SKU列表
     *
     * @param spuIds SPU编号列表
     * @return SKU列表
     */
    List<ProductSku> selectSkuListBySpuIds(@Param("spuIds") Collection<Long> spuIds);

}