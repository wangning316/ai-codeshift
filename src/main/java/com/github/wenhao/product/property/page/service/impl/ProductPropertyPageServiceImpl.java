package com.github.wenhao.product.property.page.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.wenhao.product.property.entity.po.ProductProperty;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageReqVO;
import com.github.wenhao.product.property.page.controller.vo.ProductPropertyPageRespVO;
import com.github.wenhao.product.property.page.mapper.ProductPropertyPageMapper;
import com.github.wenhao.product.property.page.service.ProductPropertyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性项分页查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductPropertyPageServiceImpl implements ProductPropertyPageService {

    private final ProductPropertyPageMapper productPropertyPageMapper;

    @Override
    public IPage<ProductPropertyPageRespVO> getPropertyPage(ProductPropertyPageReqVO reqVO) {
        // 1. 数据库操作：根据分页参数和查询条件查询商品属性项列表
        // 构建分页对象
        int pageNo = reqVO.getPageNo() != null ? reqVO.getPageNo() : 1;
        int pageSize = reqVO.getPageSize() != null ? reqVO.getPageSize() : 10;
        Page<ProductProperty> page = new Page<>(pageNo, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<ProductProperty> queryWrapper = new LambdaQueryWrapper<>();
        // 若查询参数`属性项名称`不为空，则按属性项名称精确查询
        if (StringUtils.hasText(reqVO.getName())) {
            queryWrapper.eq(ProductProperty::getName, reqVO.getName());
        }
        // 若查询参数`状态`不为空，则按状态精确查询
        if (reqVO.getStatus() != null) {
            // ProductProperty实体中没有status字段，这里暂时不处理，实际业务可能需要扩展实体
        }
        // 若查询参数`创建时间范围数组`不为空，则按传入的时间范围查询
        if (reqVO.getCreateTime() != null && reqVO.getCreateTime().length == 2) {
            LocalDateTime startTime = reqVO.getCreateTime()[0];
            LocalDateTime endTime = reqVO.getCreateTime()[1];
            if (startTime != null) {
                queryWrapper.ge(ProductProperty::getCreateTime, startTime);
            }
            if (endTime != null) {
                queryWrapper.le(ProductProperty::getCreateTime, endTime);
            }
        }

        // 执行分页查询
        IPage<ProductProperty> productPropertyPage = productPropertyPageMapper.selectPage(page, queryWrapper);

        // 2. 数据转换：将entity分页结果转换为响应参数分页结果
        List<ProductPropertyPageRespVO> respVOList = productPropertyPage.getRecords().stream()
                .map(productProperty -> {
                    ProductPropertyPageRespVO respVO = new ProductPropertyPageRespVO();
                    BeanUtils.copyProperties(productProperty, respVO);
                    return respVO;
                })
                .collect(Collectors.toList());

        // 构建返回的分页结果
        Page<ProductPropertyPageRespVO> respPage = new Page<>(productPropertyPage.getCurrent(), productPropertyPage.getSize(), productPropertyPage.getTotal());
        respPage.setRecords(respVOList);

        // 3. 方法返回
        return respPage;
    }
}