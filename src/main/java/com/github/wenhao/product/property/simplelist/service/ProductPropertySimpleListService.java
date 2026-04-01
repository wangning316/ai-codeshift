package com.github.wenhao.product.property.simplelist.service;

import com.github.wenhao.product.property.simplelist.controller.vo.ProductPropertySimpleListRespVO;

import java.util.List;

/**
 * 商品属性项_查询属性项精简列表Service接口
 */
public interface ProductPropertySimpleListService {

    /**
     * 查询属性项精简列表
     *
     * @return 属性项精简列表
     */
    List<ProductPropertySimpleListRespVO> getPropertySimpleList();
}