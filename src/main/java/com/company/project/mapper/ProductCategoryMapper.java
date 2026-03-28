package com.company.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.entity.po.ProductCategoryPO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 商品分类(mapper)
 */
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryPO> {
    
    /**
     * 根据父分类编号从数据库查询商品分类
     *
     * @param parentId 父分类编号
     * @return 商品分类列表
     */
    List<ProductCategoryPO> selectByParentId(Long parentId);
    
    /**
     * 根据分类名称、开启状态、父分类编号、父分类编号数组有值的组合参数从数据库查询商品分类列表
     *
     * @param name 分类名称
     * @param status 开启状态
     * @param parentId 父分类编号
     * @param parentIds 父分类编号数组
     * @return 商品分类列表
     */
    List<ProductCategoryPO> selectByCondition(String name, Integer status, Long parentId, List<Long> parentIds);
    
    /**
     * 根据分类编号从数据库删除商品分类
     *
     * @param id 分类编号
     * @return 删除影响的行数
     */
    int deleteById(Long id);
    
    /**
     * 根据分类名称和父分类编号查询商品分类
     *
     * @param name     分类名称
     * @param parentId 父分类编号
     * @return 商品分类实体
     */
    ProductCategoryPO selectByNameAndParentId(String name, Long parentId);
}