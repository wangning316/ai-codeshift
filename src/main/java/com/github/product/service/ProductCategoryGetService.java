package com.github.product.service;

import com.github.product.controller.vo.GetProductCategoryRespVO;

/**
 * 商品分类_查询(service)
 * 查询商品分类
 */
public interface ProductCategoryGetService {

    /**
     * 查询商品分类
     *
     * @param id 分类编号
     * @return 查询商品分类-响应参数
     */
    GetProductCategoryRespVO getProductCategory(Long id);
}