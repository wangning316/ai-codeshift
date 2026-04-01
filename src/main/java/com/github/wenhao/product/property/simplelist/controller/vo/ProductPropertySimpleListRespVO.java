package com.github.wenhao.product.property.simplelist.controller.vo;

import lombok.Data;

/**
 * 商品属性项_查询属性项精简列表-响应参数
 */
@Data
public class ProductPropertySimpleListRespVO {

    /**
     * 属性编号
     */
    private Long id;

    /**
     * 属性项名称
     */
    private String name;
}