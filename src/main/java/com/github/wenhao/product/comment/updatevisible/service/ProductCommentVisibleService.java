package com.github.wenhao.product.comment.updatevisible.service;

import com.github.wenhao.product.comment.updatevisible.vo.ProductCommentUpdateVisibleReqVO;

/**
 * 商品评价更新可见性Service
 */
public interface ProductCommentVisibleService {

    /**
     * 更新商品评价可见性
     *
     * @param updateVisibleReqVO 更新可见性请求参数
     * @return 是否更新成功
     */
    Boolean updateCommentVisible(ProductCommentUpdateVisibleReqVO updateVisibleReqVO);
}