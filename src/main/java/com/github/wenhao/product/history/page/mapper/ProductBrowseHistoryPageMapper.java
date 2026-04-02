package com.github.wenhao.product.history.page.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.history.entity.po.ProductBrowseHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品浏览记录分页查询Mapper
 */
@Mapper
public interface ProductBrowseHistoryPageMapper extends BaseMapper<ProductBrowseHistory> {

}