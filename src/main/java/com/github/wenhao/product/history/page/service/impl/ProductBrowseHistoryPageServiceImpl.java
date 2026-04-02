package com.github.wenhao.product.history.page.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.wenhao.product.history.entity.po.ProductBrowseHistory;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageReqVO;
import com.github.wenhao.product.history.page.controller.vo.ProductBrowseHistoryPageRespVO;
import com.github.wenhao.product.history.page.mapper.ProductBrowseHistoryPageMapper;
import com.github.wenhao.product.history.page.mapper.ProductSpuBatchListForBrowseHistoryMapper;
import com.github.wenhao.product.history.page.service.ProductBrowseHistoryPageService;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品浏览记录分页查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductBrowseHistoryPageServiceImpl implements ProductBrowseHistoryPageService {

    private final ProductBrowseHistoryPageMapper productBrowseHistoryPageMapper;
    private final ProductSpuBatchListForBrowseHistoryMapper productSpuBatchListForBrowseHistoryMapper;

    @Override
    public IPage<ProductBrowseHistoryPageRespVO> getBrowseHistoryPage(ProductBrowseHistoryPageReqVO reqVO) {
        // 1. 数据库操作：根据分页参数和查询条件查询商品浏览记录列表
        // 构建分页对象
        int pageNo = reqVO.getPageNo() != null ? reqVO.getPageNo() : 1;
        int pageSize = reqVO.getPageSize() != null ? reqVO.getPageSize() : 10;
        Page<ProductBrowseHistory> page = new Page<>(pageNo, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<ProductBrowseHistory> queryWrapper = new LambdaQueryWrapper<>();
        // 若查询参数`用户编号`不为空，则按用户编号精确查询
        if (reqVO.getUserId() != null) {
            queryWrapper.eq(ProductBrowseHistory::getUserId, reqVO.getUserId());
        }
        // 若查询参数`用户是否删除`不为空，则按用户是否删除精确查询
        if (reqVO.getUserDeleted() != null) {
            queryWrapper.eq(ProductBrowseHistory::getUserDeleted, reqVO.getUserDeleted());
        }
        // 若查询参数`商品SPU编号`不为空，则按商品SPU编号精确查询
        if (reqVO.getSpuId() != null) {
            queryWrapper.eq(ProductBrowseHistory::getSpuId, reqVO.getSpuId());
        }
        // 若查询参数`创建时间`不为空，则按创建时间范围查询
        if (reqVO.getCreateTime() != null && reqVO.getCreateTime().length == 2) {
            queryWrapper.between(ProductBrowseHistory::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1]);
        }

        // 执行分页查询
        IPage<ProductBrowseHistory> productBrowseHistoryPage = productBrowseHistoryPageMapper.selectPage(page, queryWrapper);

        // 2. 数据库操作：根据商品浏览记录列表中的商品SPU编号批量查询商品SPU数据
        List<Long> spuIds = productBrowseHistoryPage.getRecords().stream()
                .map(ProductBrowseHistory::getSpuId)
                .collect(Collectors.toList());

        List<ProductSpu> productSpuList = productSpuBatchListForBrowseHistoryMapper.selectBySpuIds(spuIds);
        Map<Long, ProductSpu> spuMap = productSpuList.stream()
                .collect(Collectors.toMap(ProductSpu::getId, spu -> spu));

        // 3. 数据转换：将entity分页结果转换为响应参数分页结果
        List<ProductBrowseHistoryPageRespVO> respVOList = productBrowseHistoryPage.getRecords().stream()
                .map(browseHistory -> {
                    ProductBrowseHistoryPageRespVO respVO = new ProductBrowseHistoryPageRespVO();
                    // 设置浏览记录编号
                    respVO.setId(browseHistory.getId());
                    // 设置商品SPU编号
                    respVO.setSpuId(browseHistory.getSpuId());

                    // 如果SPU存在，则复制属性
                    ProductSpu spu = spuMap.get(browseHistory.getSpuId());
                    if (spu != null) {
                        respVO.setSpuName(spu.getName());
                        respVO.setPicUrl(spu.getPicUrl());
                        respVO.setPrice(spu.getPrice());
                        respVO.setSalesCount(spu.getSalesCount());
                        respVO.setStock(spu.getStock());
                    }
                    return respVO;
                })
                .collect(Collectors.toList());

        // 构建返回的分页结果
        Page<ProductBrowseHistoryPageRespVO> respPage = new Page<>(productBrowseHistoryPage.getCurrent(), productBrowseHistoryPage.getSize(), productBrowseHistoryPage.getTotal());
        respPage.setRecords(respVOList);

        // 4. 方法返回
        return respPage;
    }
}