package com.github.wenhao.product.category.delete.service;

/**
 * 商品分类删除Service
 */
public interface ProductCategoryDeleteService {

    /**
     * 删除商品分类
     *
     * @param id 分类编号
     * @return 删除结果
     */
    Boolean deleteCategory(Long id);
}