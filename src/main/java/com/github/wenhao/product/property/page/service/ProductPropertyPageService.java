package com.github.wenhao.product.property.page.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageReqVO;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageRespVO;

/**
 * 商品属性项分页查询Service接口
 */
public interface ProductPropertyPageService {

    /**
     * 查询属性项分页
     *
     * @param reqVO 请求参数
     * @return 属性项分页数据
     */
    IPage<ProductPropertyPageRespVO> getPropertyPage(ProductPropertyPageReqVO reqVO);
}