package com.github.wenhao.product.category.create.service;

import com.github.wenhao.product.category.create.vo.ProductCategoryCreateReqVO;

/**
 * 商品分类创建Service接口
 */
public interface ProductCategoryCreateService {

    /**
     * 创建商品分类
     *
     * @param createReqVO 创建请求参数
     * @return 创建成功的商品分类编号
     */
    Long createCategory(ProductCategoryCreateReqVO createReqVO);
}