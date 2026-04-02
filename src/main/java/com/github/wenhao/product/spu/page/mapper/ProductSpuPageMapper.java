package com.github.wenhao.product.spu.page.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品SPU分页查询Mapper
 */
@Mapper
public interface ProductSpuPageMapper extends BaseMapper<ProductSpu> {

}