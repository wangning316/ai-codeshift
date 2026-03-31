package com.github.wenhao.product.brand.listallsimple.service.impl;

import com.github.wenhao.product.brand.entity.po.ProductBrand;
import com.github.wenhao.product.brand.listallsimple.controller.vo.ProductBrandListAllSimpleRespVO;
import com.github.wenhao.product.brand.listallsimple.mapper.ProductBrandListAllSimpleMapper;
import com.github.wenhao.product.brand.listallsimple.service.ProductBrandListAllSimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品品牌精简信息查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductBrandListAllSimpleServiceImpl implements ProductBrandListAllSimpleService {

    private static final Integer BRAND_STATUS_ENABLED = 0;

    private final ProductBrandListAllSimpleMapper productBrandListAllSimpleMapper;

    @Override
    public List<ProductBrandListAllSimpleRespVO> getBrandSimpleList() {
        // 1. 数据库操作：查询状态为开启的所有商品品牌列表
        List<ProductBrand> productBrandList = productBrandListAllSimpleMapper.selectListByStatus(BRAND_STATUS_ENABLED);

        if (productBrandList == null || productBrandList.isEmpty()) {
            return Collections.emptyList();
        }

        // 2. 数据转换：将entity列表转换为响应参数列表
        List<ProductBrandListAllSimpleRespVO> respVOList = productBrandList.stream()
                .map(productBrand -> {
                    ProductBrandListAllSimpleRespVO respVO = new ProductBrandListAllSimpleRespVO();
                    BeanUtils.copyProperties(productBrand, respVO);
                    return respVO;
                })
                .collect(Collectors.toList());

        // 3. 方法返回
        return respVOList;
    }
}