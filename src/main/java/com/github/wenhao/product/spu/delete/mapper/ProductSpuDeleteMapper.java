package com.github.wenhao.product.spu.delete.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.spu.entity.po.ProductSku;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface ProductSpuDeleteMapper extends BaseMapper<ProductSpu> {

    /**
     * 根据SPU编号查询SPU
     *
     * @param id SPU编号
     * @return SPU对象
     */
    default ProductSpu selectSpuById(Long id) {
        return selectOne(new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<ProductSpu>()
            .eq(ProductSpu::getId, id));
    }

    /**
     * 根据SPU编号删除SKU
     *
     * @param spuId SPU编号
     * @return 删除数量
     */
    @Delete("DELETE FROM product_sku WHERE spu_id = #{spuId}")
    int deleteSkuBySpuId(@Param("spuId") Long spuId);
}