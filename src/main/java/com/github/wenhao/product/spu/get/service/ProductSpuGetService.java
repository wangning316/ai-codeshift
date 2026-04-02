package com.github.wenhao.product.spu.get.service;

import com.github.wenhao.product.spu.get.controller.vo.ProductSpuGetDetailRespVO;

/**
 * 商品SPU查询Service接口
 */
public interface ProductSpuGetService {

    /**
     * 查询商品SPU明细，包含关联的SKU列表
     *
     * @param id 商品SPU编号
     * @return 商品SPU明细
     */
    ProductSpuGetDetailRespVO getSpuDetail(Long id);
}