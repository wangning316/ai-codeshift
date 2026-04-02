package com.github.wenhao.product.spu.delete.service;

/**
 * 商品SPU删除Service
 */
public interface ProductSpuDeleteService {

    /**
     * 删除商品SPU，同步删除关联的商品SKU
     *
     * @param id SPU编号
     * @return 删除结果
     */
    Boolean deleteSpu(Long id);
}