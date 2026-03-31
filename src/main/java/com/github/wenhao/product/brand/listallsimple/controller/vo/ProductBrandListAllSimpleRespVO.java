package com.github.wenhao.product.brand.listallsimple.controller.vo;

import lombok.Data;

/**
 * 商品品牌精简信息响应VO
 */
@Data
public class ProductBrandListAllSimpleRespVO {

    /**
     * 品牌编号
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;
}