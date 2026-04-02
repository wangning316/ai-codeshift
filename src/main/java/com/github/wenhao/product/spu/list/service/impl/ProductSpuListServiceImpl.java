package com.github.wenhao.product.spu.list.service.impl;

import com.github.wenhao.product.spu.entity.po.ProductSku;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import com.github.wenhao.product.spu.list.controller.vo.ProductSpuListRespVO;
import com.github.wenhao.product.spu.list.mapper.ProductSpuListMapper;
import com.github.wenhao.product.spu.list.service.ProductSpuListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 商品SPU列表查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductSpuListServiceImpl implements ProductSpuListService {

    private final ProductSpuListMapper productSpuListMapper;

    @Override
    public List<ProductSpuListRespVO> getSpuList(Collection<Long> spuIds) {
        // 1. 数据库操作：根据商品SPU编号列表查询商品SPU列表
        List<ProductSpu> spuList = productSpuListMapper.selectBatchIds(spuIds);

        if (Objects.isNull(spuList) || spuList.isEmpty()) {
            return Collections.emptyList();
        }

        // 2. 数据库操作：根据商品SPU编号列表查询商品SKU列表
        List<ProductSku> skuList = productSpuListMapper.selectSkuListBySpuIds(spuIds);

        // 3. 数据转换：将对应的商品SKU列表设置到每个商品SPU中
        // 构建SPU ID到SKU列表的映射
        Map<Long, List<ProductSku>> spuIdToSkusMap = skuList.stream()
                .collect(Collectors.groupingBy(ProductSku::getSpuId));

        // 保持传入ID的顺序
        List<ProductSpuListRespVO> respVOList = new ArrayList<>();
        for (Long spuId : spuIds) {
            // 找到对应的SPU
            ProductSpu productSpu = spuList.stream()
                    .filter(spu -> spu.getId().equals(spuId))
                    .findFirst()
                    .orElse(null);

            if (Objects.nonNull(productSpu)) {
                ProductSpuListRespVO respVO = new ProductSpuListRespVO();
                BeanUtils.copyProperties(productSpu, respVO);

                // 设置SKU列表
                List<ProductSku> relatedSkus = spuIdToSkusMap.getOrDefault(spuId, Collections.emptyList());
                if (!relatedSkus.isEmpty()) {
                    List<ProductSpuListRespVO.ProductSkuRespVO> skuRespVOList = relatedSkus.stream()
                            .map(this::convertToSkuRespVO)
                            .collect(Collectors.toList());
                    respVO.setSkus(skuRespVOList);
                } else {
                    respVO.setSkus(Collections.emptyList());
                }

                respVOList.add(respVO);
            }
        }

        // 4. 方法返回
        return respVOList;
    }

    /**
     * 将ProductSku转换为ProductSkuRespVO
     */
    private ProductSpuListRespVO.ProductSkuRespVO convertToSkuRespVO(ProductSku sku) {
        ProductSpuListRespVO.ProductSkuRespVO skuRespVO = new ProductSpuListRespVO.ProductSkuRespVO();
        BeanUtils.copyProperties(sku, skuRespVO);

        // 转换属性列表
        if (Objects.nonNull(sku.getProperties()) && !sku.getProperties().isEmpty()) {
            List<ProductSpuListRespVO.ProductSkuRespVO.Property> properties = sku.getProperties().stream()
                    .map(this::convertToProperty)
                    .collect(Collectors.toList());
            skuRespVO.setProperties(properties);
        } else {
            skuRespVO.setProperties(Collections.emptyList());
        }

        return skuRespVO;
    }

    /**
     * 将Property转换为PropertyRespVO
     */
    private ProductSpuListRespVO.ProductSkuRespVO.Property convertToProperty(ProductSku.Property property) {
        ProductSpuListRespVO.ProductSkuRespVO.Property propertyRespVO = new ProductSpuListRespVO.ProductSkuRespVO.Property();
        BeanUtils.copyProperties(property, propertyRespVO);
        return propertyRespVO;
    }
}