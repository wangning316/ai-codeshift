package com.github.wenhao.product.comment.updatevisible.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.wenhao.product.comment.entity.po.ProductComment;
import com.github.wenhao.product.comment.updatevisible.mapper.ProductCommentVisibleMapper;
import com.github.wenhao.product.comment.updatevisible.service.ProductCommentVisibleService;
import com.github.wenhao.product.comment.updatevisible.vo.ProductCommentUpdateVisibleReqVO;
import com.github.wenhao.product.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 商品评价更新可见性Service实现
 */
@Service
@RequiredArgsConstructor
public class ProductCommentVisibleServiceImpl implements ProductCommentVisibleService {

    private final ProductCommentVisibleMapper productCommentVisibleMapper;

    @Override
    public Boolean updateCommentVisible(ProductCommentUpdateVisibleReqVO updateVisibleReqVO) {
        // 查询评价是否存在
        LambdaQueryWrapper<ProductComment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductComment::getId, updateVisibleReqVO.getId());
        ProductComment existComment = productCommentVisibleMapper.selectOne(queryWrapper);
        if (existComment == null) {
            throw new BusinessException("1_008_007_000", "商品评价不存在");
        }

        // 更新可见性
        LambdaUpdateWrapper<ProductComment> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ProductComment::getId, updateVisibleReqVO.getId())
            .set(ProductComment::getVisible, updateVisibleReqVO.getVisible());
        int rows = productCommentVisibleMapper.update(null, updateWrapper);
        return rows > 0;
    }
}