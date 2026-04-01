package com.github.wenhao.product.property.create.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wenhao.product.property.create.mapper.ProductPropertyCreateMapper;
import com.github.wenhao.product.property.create.service.ProductPropertyCreateService;
import com.github.wenhao.product.property.create.vo.ProductPropertyCreateReqVO;
import com.github.wenhao.product.property.entity.po.ProductProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 商品属性项创建Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductPropertyCreateServiceImpl implements ProductPropertyCreateService {

    private final ProductPropertyCreateMapper productPropertyCreateMapper;

    @Override
    public Long createProperty(ProductPropertyCreateReqVO createReqVO) {
        // 2. 参数校验：根据传入的属性项名称查询数据库校验属性项名称是否已存在
        ProductProperty existProperty = productPropertyCreateMapper.selectOne(
            new LambdaQueryWrapper<ProductProperty>()
                .eq(ProductProperty::getName, createReqVO.getName())
        );
        if (existProperty != null) {
            return existProperty.getId();
        }

        // 3. 数据转换：将请求参数转换为数据库实体对象
        ProductProperty productProperty = new ProductProperty();
        BeanUtils.copyProperties(createReqVO, productProperty);

        // 4. 数据库操作：插入数据库
        productPropertyCreateMapper.insert(productProperty);

        // 5. 方法返回：返回数据库自动生成的商品属性项编号
        return productProperty.getId();
    }
}