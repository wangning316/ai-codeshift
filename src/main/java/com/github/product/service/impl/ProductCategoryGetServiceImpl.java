package com.github.product.service.impl;

import com.github.product.controller.vo.GetProductCategoryRespVO;
import com.github.product.entity.po.ProductCategory;
import com.github.product.exception.BusinessException;
import com.github.product.mapper.ProductCategoryGetMapper;
import com.github.product.service.ProductCategoryGetService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品分类_查询(service)实现类
 * 查询商品分类
 */
@Service
public class ProductCategoryGetServiceImpl implements ProductCategoryGetService {

    @Resource
    private ProductCategoryGetMapper productCategoryGetMapper;

    /**
     * 查询商品分类
     * 业务逻辑：
     * 1. 数据库操作：根据`查询商品分类-请求参数（Query）-分类编号`使用`商品分类(mapper)`的数据库操作对象根据`分类编号`查询唯一的`商品分类(entity)`。
     * 2. 数据转换：将数据库查询的`商品分类_查询(entity)`，转换为`查询商品分类-响应参数`数据对象。
     * 3. 方法返回：返回`查询商品分类-响应参数`数据对象。
     *
     * @param id 分类编号
     * @return 查询商品分类-响应参数
     */
    @Override
    public GetProductCategoryRespVO getProductCategory(Long id) {
        // 1. 数据库操作：根据`查询商品分类-请求参数（Query）-分类编号`使用`商品分类(mapper)`的数据库操作对象根据`分类编号`查询唯一的`商品分类(entity)`。
        ProductCategory productCategory = productCategoryGetMapper.selectById(id);

        // 如果未找到分类，抛出异常
        if (productCategory == null) {
            throw new BusinessException("1_008_002_001", "商品分类不存在");
        }

        // 2. 数据转换：将数据库查询的`商品分类_查询(entity)`，转换为`查询商品分类-响应参数`数据对象。
        GetProductCategoryRespVO respVO = new GetProductCategoryRespVO();
        BeanUtils.copyProperties(productCategory, respVO);

        // 3. 方法返回：返回`查询商品分类-响应参数`数据对象。
        return respVO;
    }
}