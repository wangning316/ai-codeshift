package com.github.wenhao.product.spu.get.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.exception.BusinessException;
import com.github.wenhao.product.spu.entity.po.ProductSku;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import com.github.wenhao.product.spu.get.controller.vo.ProductSpuGetDetailRespVO;
import com.github.wenhao.product.spu.get.mapper.ProductSpuGetMapper;
import com.github.wenhao.product.spu.get.service.ProductSpuGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 商品SPU查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductSpuGetServiceImpl implements ProductSpuGetService {

    private final ProductSpuGetMapper productSpuGetMapper;

    @Override
    public ProductSpuGetDetailRespVO getSpuDetail(Long id) {
        // 1. 数据库操作：根据商品SPU编号查询唯一的商品SPU
        LambdaQueryWrapper<ProductSpu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductSpu::getId, id);
        ProductSpu productSpu = productSpuGetMapper.selectOne(wrapper);

        if (Objects.isNull(productSpu)) {
            throw new BusinessException("商品SPU不存在");
        }

        // 2. 数据库操作：根据SPU编号查询该SPU关联的全部商品SKU列表
        List<ProductSku> skuList = productSpuGetMapper.selectSkuListBySpuId(id);

        // 3. 数据转换：将商品SPU entity和商品SKU列表转换为响应参数
        ProductSpuGetDetailRespVO respVO = new ProductSpuGetDetailRespVO();
        BeanUtils.copyProperties(productSpu, respVO);

        // 转换SKU列表
        if (Objects.nonNull(skuList) && !skuList.isEmpty()) {
            List<ProductSpuGetDetailRespVO.ProductSkuRespVO> skuRespVOList = skuList.stream()
                    .map(this::convertToSkuRespVO)
                    .collect(Collectors.toList());
            respVO.setSkus(skuRespVOList);
        } else {
            respVO.setSkus(Collections.emptyList());
        }

        // 4. 方法返回
        return respVO;
    }

    /**
     * 将ProductSku转换为ProductSkuRespVO
     */
    private ProductSpuGetDetailRespVO.ProductSkuRespVO convertToSkuRespVO(ProductSku sku) {
        ProductSpuGetDetailRespVO.ProductSkuRespVO skuRespVO = new ProductSpuGetDetailRespVO.ProductSkuRespVO();
        BeanUtils.copyProperties(sku, skuRespVO);

        // 转换属性列表
        if (Objects.nonNull(sku.getProperties()) && !sku.getProperties().isEmpty()) {
            List<ProductSpuGetDetailRespVO.ProductSkuRespVO.Property> properties = sku.getProperties().stream()
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
    private ProductSpuGetDetailRespVO.ProductSkuRespVO.Property convertToProperty(ProductSku.Property property) {
        ProductSpuGetDetailRespVO.ProductSkuRespVO.Property propertyRespVO = new ProductSpuGetDetailRespVO.ProductSkuRespVO.Property();
        BeanUtils.copyProperties(property, propertyRespVO);
        return propertyRespVO;
    }
}