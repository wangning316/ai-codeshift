package com.github.wenhao.product.spu.get.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.spu.entity.po.ProductSku;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductSpuGetMapper extends BaseMapper<ProductSpu> {

    /**
     * 根据SPU编号查询SKU列表
     *
     * @param spuId SPU编号
     * @return SKU列表
     */
    java.util.List<ProductSku> selectSkuListBySpuId(@Param("spuId") Long spuId);
}