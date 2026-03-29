package com.github.product.service;

import com.github.product.controller.vo.UpdateProductCategoryReqVO;

/**
 * 商品分类_更新(service)
 *
 * 独立的商品分类_更新service类，ProductCategoryUpdateService。
 */
public interface ProductCategoryUpdateService {
    /**
     * 更新商品分类
     */
    Boolean updateProductCategory(UpdateProductCategoryReqVO reqVO);
}