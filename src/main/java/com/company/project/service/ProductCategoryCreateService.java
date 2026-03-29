package com.company.project.service;

import com.company.project.entity.po.ProductCategory;

/**
 * 商品分类_创建(service)
 *
 * 独立的商品分类_创建service类，ProductCategoryCreateService。
 *
 * 方法描述:
 * - 创建商品分类
 */
public interface ProductCategoryCreateService {
    
    /**
     * 创建商品分类
     * 
     * 业务逻辑:
     * 1. 传入创建商品分类-请求参数(Body)对象。
     * 2. 参数校验：若传入的创建商品分类-请求参数(Body)-父分类编号为根分类默认标识（值为0L），直接跳过校验。
     * 3. 参数校验：根据传入的创建商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在，若不存在则抛出"父分类不存在"业务异常，错误码：1_008_001_001；
     * 4. 参数校验：根据传入的创建商品分类-请求参数(Body)-父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L），若父分类为二级及以下层级，抛出"父分类不能是二级分类"业务异常，错误码：1_008_001_002。
     * 5. 数据转换：将传入的创建商品分类-请求参数(Body)，转换为数据库对应的商品分类(entity)数据对象。
     * 6. 数据库操作：使用商品分类_创建(mapper)的数据库操作对象将商品分类(entity)数据对象插入数据库。
     * 7. 方法返回：返回数据库自动生成的商品商品分类(entity)-分类编号。
     * 
     * @param parentId 父分类编号
     * @param name 分类名称
     * @param picUrl 移动端分类图
     * @param sort 分类排序
     * @param status 开启状态
     * @param description 分类描述
     * @return 创建成功的商品分类编号
     */
    Long createProductCategory(Long parentId, String name, String picUrl, Integer sort, Integer status, String description);
}