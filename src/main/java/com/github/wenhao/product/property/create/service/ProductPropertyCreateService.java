package com.github.wenhao.product.property.create.service;

import com.github.wenhao.product.property.create.vo.ProductPropertyCreateReqVO;

/**
 * 商品属性项创建Service接口
 */
public interface ProductPropertyCreateService {

    /**
     * 创建商品属性项
     *
     * @param createReqVO 创建请求参数
     * @return 创建成功的商品属性项编号
     */
    Long createProperty(ProductPropertyCreateReqVO createReqVO);
}