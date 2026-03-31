package com.github.wenhao.product.brand.listallsimple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.wenhao.product.brand.entity.po.ProductBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品品牌精简信息Mapper
 */
@Mapper
public interface ProductBrandListAllSimpleMapper extends BaseMapper<ProductBrand> {

    /**
     * 根据品牌状态查询品牌列表
     *
     * @param status 品牌状态
     * @return 品牌列表
     */
    List<ProductBrand> selectListByStatus(@Param("status") Integer status);
}