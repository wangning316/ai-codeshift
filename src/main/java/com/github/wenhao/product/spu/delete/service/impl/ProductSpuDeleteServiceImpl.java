package com.github.wenhao.product.spu.delete.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.spu.delete.mapper.ProductSpuDeleteMapper;
import com.github.wenhao.product.spu.delete.service.ProductSpuDeleteService;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import com.github.wenhao.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 商品SPU删除Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductSpuDeleteServiceImpl implements ProductSpuDeleteService {

    private static final Integer SPU_STATUS_RECYCLE_BIN = -1;

    private final ProductSpuDeleteMapper productSpuDeleteMapper;

    @Override
    public Boolean deleteSpu(Long id) {
        // 1. 参数校验：根据SPU编号查询数据库校验SPU是否真实存在
        ProductSpu spu = productSpuDeleteMapper.selectOne(
            new LambdaQueryWrapper<ProductSpu>()
                .eq(ProductSpu::getId, id)
        );
        if (spu == null) {
            throw new BusinessException("1_008_005_000", "商品 SPU 不存在");
        }

        // 2. 数据校验：校验SPU状态必须为回收站状态才可删除
        if (!SPU_STATUS_RECYCLE_BIN.equals(spu.getStatus())) {
            throw new BusinessException("1_008_005_004", "商品 SPU 不处于回收站状态");
        }

        // 3. 数据库操作：删除SPU
        productSpuDeleteMapper.deleteById(id);

        // 4. 关联数据删除：删除该商品下所有关联的SKU数据
        productSpuDeleteMapper.deleteSkuBySpuId(id);

        return true;
    }
}