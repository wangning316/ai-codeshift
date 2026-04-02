package com.github.wenhao.product.spu.list.service;

import com.github.wenhao.product.spu.list.controller.vo.ProductSpuListReqVO;
import com.github.wenhao.product.spu.list.controller.vo.ProductSpuListRespVO;

import java.util.Collection;
import java.util.List;

/**
 * 商品SPU列表查询Service
 */
public interface ProductSpuListService {

    /**
     * 根据SPU编号集合查询商品SPU列表，并严格保持传入ID的顺序
     *
     * @param spuIds SPU编号集合
     * @return 商品SPU列表
     */
    List<ProductSpuListRespVO> getSpuList(Collection<Long> spuIds);

}