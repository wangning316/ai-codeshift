package com.github.wenhao.product.brand.listallsimple.service;

import com.github.wenhao.product.brand.listallsimple.controller.vo.ProductBrandListAllSimpleRespVO;

import java.util.List;

/**
 * 商品品牌精简信息查询Service接口
 */
public interface ProductBrandListAllSimpleService {

    /**
     * 查询品牌精简信息列表
     *
     * @return 品牌精简信息列表
     */
    List<ProductBrandListAllSimpleRespVO> getBrandSimpleList();
}