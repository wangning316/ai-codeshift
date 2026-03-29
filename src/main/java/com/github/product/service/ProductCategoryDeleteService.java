package com.github.product.service;

/**
 * 商品分类_删除(service)
 *
 * 独立的商品分类_删除service类，ProductCategoryDeleteService。
 *
 * 方法描述:
 * - 删除商品分类
 */
public interface ProductCategoryDeleteService {
    
    /**
     * 删除商品分类
     * 
     * 业务逻辑:
     * 1. 传入商品分类编号。
     * 2. 参数校验：根据传入的商品分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验商品分类是否真实存在，若不存在则抛出"商品分类不存在"业务异常，错误码：1_008_002_001；
     * 3. 参数校验：根据传入的商品分类编号查询其是否存在子分类，若存在子分类则抛出"存在子分类，无法删除"业务异常，错误码：1_008_002_002；
     * 4. 数据库操作：使用商品分类_删除(mapper)的数据库操作对象根据商品分类编号进行逻辑删除操作；
     * 5. 方法返回：返回删除结果，true表示删除成功。
     * 
     * @param id 待删除的商品分类编号
     * @return 删除结果，true=成功
     */
    Boolean deleteProductCategory(Long id);
}