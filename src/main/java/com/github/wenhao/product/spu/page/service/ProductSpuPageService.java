package com.github.wenhao.product.spu.page.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageReqVO;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageRespVO;

/**
 * 商品SPU分页查询Service接口
 */
public interface ProductSpuPageService {

    /**
     * 分页查询商品SPU
     *
     * @param reqVO 请求参数
     * @return 商品SPU分页数据
     */
    IPage<ProductSpuPageRespVO> getSpuPage(ProductSpuPageReqVO reqVO);
}