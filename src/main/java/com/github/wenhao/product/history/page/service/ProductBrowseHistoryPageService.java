package com.github.wenhao.product.history.page.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageReqVO;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageRespVO;

/**
 * 商品浏览记录分页查询Service接口
 */
public interface ProductBrowseHistoryPageService {

    /**
     * 查询商品浏览记录分页
     *
     * @param reqVO 请求参数
     * @return 商品浏览记录分页数据
     */
    IPage<ProductBrowseHistoryPageRespVO> getBrowseHistoryPage(ProductBrowseHistoryPageReqVO reqVO);
}