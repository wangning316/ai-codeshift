package com.github.wenhao.product.comment.updatevisible.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.comment.entity.po.ProductComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价更新可见性Mapper
 */
@Mapper
public interface ProductCommentVisibleMapper extends BaseMapper<ProductComment> {
}