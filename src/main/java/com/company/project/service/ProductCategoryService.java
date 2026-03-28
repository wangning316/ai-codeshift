package com.company.project.service;

import com.company.project.dto.CreateProductCategoryDTO;
import com.company.project.entity.po.ProductCategoryPO;

/**
 * 商品分类(service)
 */
public interface ProductCategoryService {
    
    /**
     * 创建商品分类
     *
     * @param createProductCategoryDTO 创建商品分类DTO
     * @return 创建后的商品分类ID
     */
    Long createProductCategory(CreateProductCategoryDTO createProductCategoryDTO);

    /**
     * 查询商品分类
     *
     * @param id 分类编号
     * @return 商品分类实体
     */
    ProductCategoryPO getProductCategory(Long id);
    
    /**
     * 删除商品分类
     *
     * @param id 分类编号
     * @return 删除结果，true=成功
     */
    Boolean deleteProductCategory(Long id);
    
    /**
     * 更新商品分类
     *
     * @param productCategory 商品分类实体
     * @return 更新结果，true=成功
     */
    Boolean updateProductCategory(ProductCategoryPO productCategory);

    /**
     * 查询商品分类列表
     *
     * @param name 分类名称
     * @param status 开启状态
     * @param parentId 父分类编号
     * @param parentIds 父分类编号数组
     * @return 商品分类列表
     */
    java.util.List<ProductCategoryPO> getProductCategoryList(String name, Integer status, Long parentId, java.util.List<Long> parentIds);
}