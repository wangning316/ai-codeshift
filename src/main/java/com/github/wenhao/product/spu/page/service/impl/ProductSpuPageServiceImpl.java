package com.github.wenhao.product.spu.page.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.wenhao.product.spu.entity.po.ProductSpu;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageReqVO;
import com.github.wenhao.product.spu.page.controller.vo.ProductSpuPageRespVO;
import com.github.wenhao.product.spu.page.mapper.ProductSpuPageMapper;
import com.github.wenhao.product.spu.page.service.ProductSpuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品SPU分页查询Service实现类
 */
@Service
@RequiredArgsConstructor
public class ProductSpuPageServiceImpl implements ProductSpuPageService {

    private final ProductSpuPageMapper productSpuPageMapper;

    @Override
    public IPage<ProductSpuPageRespVO> getSpuPage(ProductSpuPageReqVO reqVO) {
        // 1. 数据库操作：根据分页参数和查询条件查询商品SPU列表
        // 构建分页对象
        int pageNo = reqVO.getPageNo() != null ? reqVO.getPageNo() : 1;
        int pageSize = reqVO.getPageSize() != null ? reqVO.getPageSize() : 10;
        Page<ProductSpu> page = new Page<>(pageNo, pageSize);

        // 构建查询条件
        LambdaQueryWrapper<ProductSpu> queryWrapper = new LambdaQueryWrapper<>();
        
        // 若查询参数`商品名称`不为空，则按商品名称模糊查询
        if (StringUtils.hasText(reqVO.getName())) {
            queryWrapper.like(ProductSpu::getName, reqVO.getName());
        }
        // 若查询参数`商品分类编号`不为空，则按商品分类编号精确查询
        if (reqVO.getCategoryId() != null) {
            queryWrapper.eq(ProductSpu::getCategoryId, reqVO.getCategoryId());
        }
        // 若查询参数`创建时间范围数组`不为空，则按传入的时间范围查询
        if (reqVO.getCreateTime() != null && reqVO.getCreateTime().length == 2) {
            LocalDateTime startTime = reqVO.getCreateTime()[0];
            LocalDateTime endTime = reqVO.getCreateTime()[1];
            if (startTime != null) {
                queryWrapper.ge(ProductSpu::getCreateTime, startTime);
            }
            if (endTime != null) {
                queryWrapper.le(ProductSpu::getCreateTime, endTime);
            }
        }
        
        // 若查询参数`前端请求的tab类型`不为空，则根据不同tab类型执行对应筛选条件
        if (reqVO.getTabType() != null) {
            Integer tabType = reqVO.getTabType();
            switch (tabType) {
                case 0:
                    // tabType值为0：则按`商品状态`为`上架`查询
                    queryWrapper.eq(ProductSpu::getStatus, 1);
                    break;
                case 1:
                    // tabType值为1：则按`商品状态`为`上架`查询
                    queryWrapper.eq(ProductSpu::getStatus, 1);
                    break;
                case 2:
                    // tabType值为2：则按`库存`为0查询
                    queryWrapper.eq(ProductSpu::getStock, 0);
                    break;
                case 3:
                    // tabType值为3：则按`库存`为小于等于10且`商品状态`不为`回收站`查询
                    queryWrapper.le(ProductSpu::getStock, 10)
                            .ne(ProductSpu::getStatus, -1);
                    break;
                case 4:
                    // tabType值为4：则按`商品状态`为`回收站`查询
                    queryWrapper.eq(ProductSpu::getStatus, -1);
                    break;
                default:
                    break;
            }
        }

        // 查询结果按`sort`排序字段倒序、`id主键`倒序排序
        queryWrapper.orderByDesc(ProductSpu::getSort)
                .orderByDesc(ProductSpu::getId);

        // 执行分页查询
        IPage<ProductSpu> productSpuPage = productSpuPageMapper.selectPage(page, queryWrapper);

        // 2. 数据转换：将entity分页结果转换为响应参数分页结果
        List<ProductSpuPageRespVO> respVOList = productSpuPage.getRecords().stream()
                .map(productSpu -> {
                    ProductSpuPageRespVO respVO = new ProductSpuPageRespVO();
                    BeanUtils.copyProperties(productSpu, respVO);
                    return respVO;
                })
                .collect(Collectors.toList());

        // 构建返回的分页结果
        Page<ProductSpuPageRespVO> respPage = new Page<>(productSpuPage.getCurrent(), productSpuPage.getSize(), productSpuPage.getTotal());
        respPage.setRecords(respVOList);

        // 3. 方法返回
        return respPage;
    }
}