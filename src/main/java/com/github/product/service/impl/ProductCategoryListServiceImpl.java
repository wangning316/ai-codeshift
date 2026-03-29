package com.github.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.product.controller.vo.GetProductCategoryListReqVO;
import com.github.product.controller.vo.GetProductCategoryListRespVO;
import com.github.product.entity.po.ProductCategory;
import com.github.product.mapper.ProductCategoryListMapper;
import com.github.product.service.ProductCategoryListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品分类_查询列表(service)实现类
 * 查询商品分类列表
 */
@Service
public class ProductCategoryListServiceImpl implements ProductCategoryListService {

    @Resource
    private ProductCategoryListMapper productCategoryListMapper;

    /**
     * 查询商品分类列表
     * 业务逻辑：
     * 1. 数据库操作：可同时根据`查询商品分类-请求参数（Query）`传入的所有有值的参数使用`商品分类(mapper)_查询列表`的数据库操作对象根据`分类名称`、`开启状态`、`父分类编号`、`父分类编号数组`查询`商品分类(entity)`列表。
     * 2. 数据转换：将数据库查询的`商品分类(entity)`列表，转换为`查询商品分类列表-响应参数`数据对象。
     * 3. 方法返回：返回`查询商品分类列表-响应参数`数据对象。
     *
     * @param reqVO 请求参数
     * @return 查询商品分类列表-响应参数
     */
    @Override
    public List<GetProductCategoryListRespVO> getProductCategoryList(GetProductCategoryListReqVO reqVO) {
        // 1. 数据库操作：可同时根据`查询商品分类-请求参数（Query）`传入的所有有值的参数使用`商品分类(mapper)_查询列表`的数据库操作对象根据`分类名称`、`开启状态`、`父分类编号`、`父分类编号数组`查询`商品分类(entity)`列表。
        QueryWrapper<ProductCategory> queryWrapper = new QueryWrapper<>();
        
        if (reqVO.getParentId() != null) {
            queryWrapper.eq("parent_id", reqVO.getParentId());
        }
        if (reqVO.getName() != null && !reqVO.getName().isEmpty()) {
            queryWrapper.like("name", reqVO.getName());
        }
        if (reqVO.getStatus() != null) {
            queryWrapper.eq("status", reqVO.getStatus());
        }
        queryWrapper.orderByAsc("sort"); // 按排序字段升序排列
        
        List<ProductCategory> productCategoryList = productCategoryListMapper.selectList(queryWrapper);

        // 2. 数据转换：将数据库查询的`商品分类(entity)`列表，转换为`查询商品分类列表-响应参数`数据对象。
        List<GetProductCategoryListRespVO> respVOList = productCategoryList.stream().map(category -> {
            GetProductCategoryListRespVO respVO = new GetProductCategoryListRespVO();
            BeanUtils.copyProperties(category, respVO);
            return respVO;
        }).collect(Collectors.toList());

        // 3. 构建树形结构：将平级的分类列表构建成父子层级关系的树形结构。
        return buildTreeStructure(respVOList);
    }

    /**
     * 构建树形结构
     *
     * @param categoryList 分类列表
     * @return 树形结构的分类列表
     */
    private List<GetProductCategoryListRespVO> buildTreeStructure(List<GetProductCategoryListRespVO> categoryList) {
        // 创建一个Map，用于快速查找分类
        Map<Long, GetProductCategoryListRespVO> categoryMap = new HashMap<>();
        for (GetProductCategoryListRespVO category : categoryList) {
            categoryMap.put(category.getId(), category);
        }

        // 创建结果列表
        List<GetProductCategoryListRespVO> result = new ArrayList<>();

        // 遍历分类列表，构建树形结构
        for (GetProductCategoryListRespVO category : categoryList) {
            Long parentId = category.getParentId();
            
            // 如果是根节点（parentId为null或0），直接添加到结果列表
            if (parentId == null || parentId.equals(0L)) {
                result.add(category);
            } else {
                // 如果不是根节点，查找其父节点并添加到父节点的children列表中
                GetProductCategoryListRespVO parentCategory = categoryMap.get(parentId);
                if (parentCategory != null) {
                    if (parentCategory.getChildren() == null) {
                        parentCategory.setChildren(new ArrayList<>());
                    }
                    parentCategory.getChildren().add(category);
                }
            }
        }

        return result;
    }
}