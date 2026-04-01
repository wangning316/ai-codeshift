package com.github.wenhao.product.property.simplelist.service.impl;

import com.github.wenhao.product.property.entity.po.ProductProperty;
import com.github.wenhao.product.property.simplelist.controller.vo.ProductPropertySimpleListRespVO;
import com.github.wenhao.product.property.simplelist.mapper.ProductPropertySimpleListMapper;
import com.github.wenhao.product.property.simplelist.service.ProductPropertySimpleListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性项_查询属性项精简列表Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductPropertySimpleListServiceImpl implements ProductPropertySimpleListService {

    private final ProductPropertySimpleListMapper productPropertySimpleListMapper;

    @Override
    public List<ProductPropertySimpleListRespVO> getPropertySimpleList() {
        // 1. 数据库操作：使用mapper查询所有商品属性项对象
        List<ProductProperty> productPropertyList = productPropertySimpleListMapper.selectList();

        if (productPropertyList == null || productPropertyList.isEmpty()) {
            return Collections.emptyList();
        }

        // 2. 数据转换：将数据库查询的商品属性项列表，转换为响应参数数据对象
        List<ProductPropertySimpleListRespVO> respVOList = productPropertyList.stream()
                .map(productProperty -> {
                    ProductPropertySimpleListRespVO respVO = new ProductPropertySimpleListRespVO();
                    BeanUtils.copyProperties(productProperty, respVO);
                    return respVO;
                })
                .collect(Collectors.toList());

        // 3. 方法返回：返回响应参数数据对象
        return respVOList;
    }
}