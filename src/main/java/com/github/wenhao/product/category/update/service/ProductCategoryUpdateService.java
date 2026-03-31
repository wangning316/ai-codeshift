package com.github.wenhao.product.category.update.service;

import com.github.wenhao.product.category.update.vo.ProductCategoryUpdateReqVO;

/**
 * 商品分类更新Service接口
 */
public interface ProductCategoryUpdateService {

    /**
     * 更新商品分类
     *
     * @param updateReqVO 更新请求参数
     * @return 更新结果
     */
    Boolean updateCategory(ProductCategoryUpdateReqVO updateReqVO);
}