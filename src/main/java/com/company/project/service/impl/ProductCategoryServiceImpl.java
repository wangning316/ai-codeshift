package com.company.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.dto.CreateProductCategoryDTO;
import com.company.project.entity.po.ProductCategoryPO;
import com.company.project.exception.BusinessException;
import com.company.project.mapper.ProductCategoryMapper;
import com.company.project.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品分类服务实现类
 */
@Service
@Transactional
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategoryPO> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public Long createProductCategory(CreateProductCategoryDTO createProductCategoryDTO) {
        // 参数校验
        validateCreateParams(createProductCategoryDTO);

        // 检查同名分类是否存在
        checkDuplicateName(createProductCategoryDTO.getName(), createProductCategoryDTO.getParentId());

        // 数据转换 - 将DTO转换为实体对象
        ProductCategoryPO productCategory = new ProductCategoryPO();
        BeanUtils.copyProperties(createProductCategoryDTO, productCategory);

        // 设置默认值
        productCategory.setStatus(createProductCategoryDTO.getStatus()); // 默认启用状态
        productCategory.setDeleted(false); // 确保未被标记为删除

        // 数据库操作 - 插入数据
        productCategoryMapper.insert(productCategory);

        // 返回数据库自动生成的商品分类编号
        return productCategory.getId();
    }

    @Override
    public Boolean updateProductCategory(ProductCategoryPO productCategory) {
        // 参数校验
        validateUpdateParams(productCategory);

        // 数据库操作 - 更新数据
        int updateResult = productCategoryMapper.updateById(productCategory);

        // 返回更新结果
        return updateResult > 0;
    }

    @Override
    public ProductCategoryPO getProductCategory(Long id) {
        // 参数校验
        if (id == null || id <= 0) {
            throw new BusinessException(1_008_001_000, "分类编号不能为空或小于等于0");
        }

        // 数据库操作 - 根据分类编号查询商品分类
        QueryWrapper<ProductCategoryPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        ProductCategoryPO productCategory = productCategoryMapper.selectOne(queryWrapper);

        // 如果未找到对应的商品分类，抛出异常
        if (productCategory == null) {
            throw new BusinessException(1_008_002_001, "商品分类不存在");
        }

        // 返回查询到的商品分类
        return productCategory;
    }

    @Override
    public Boolean deleteProductCategory(Long id) {
        // 参数校验
        if (id == null || id <= 0) {
            throw new BusinessException(1_008_001_000, "分类编号不能为空或小于等于0");
        }

        // 根据传入的删除商品分类-请求参数（Query）-分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验待删除的分类编号是否真实存在
        ProductCategoryPO existingCategory = productCategoryMapper.selectById(id);
        if (existingCategory == null) {
            throw new BusinessException(1_008_001_000, "商品分类不存在");
        }

        // 根据传入的删除商品分类-请求参数（Query）-分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验该分类是否有子分类
        QueryWrapper<ProductCategoryPO> childQueryWrapper = new QueryWrapper<>();
        childQueryWrapper.eq("parent_id", id);
        int childCount = productCategoryMapper.selectCount(childQueryWrapper);
        if (childCount > 0) {
            throw new BusinessException(1_008_001_003, "存在子分类，无法删除");
        }

        // 使用商品分类(mapper)的数据库操作对象将分类编号数据对象从数据库删除
        int deleteResult = productCategoryMapper.deleteById(id);
        
        return deleteResult > 0;
    }

    @Override
    public java.util.List<ProductCategoryPO> getProductCategoryList(String name, Integer status, Long parentId, java.util.List<Long> parentIds) {
        // 使用商品分类(mapper)的数据库操作对象根据分类名称、开启状态、父分类编号、父分类编号数组查询商品分类列表
        return productCategoryMapper.selectByCondition(name, status, parentId, parentIds);
    }

    /**
     * 校验创建商品分类的参数
     *
     * @param createProductCategoryDTO 创建商品分类DTO
     */
    private void validateCreateParams(CreateProductCategoryDTO createProductCategoryDTO) {
        Long parentId = createProductCategoryDTO.getParentId();

        // 若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (parentId != null && !parentId.equals(0L)) {
            // 根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在
            QueryWrapper<ProductCategoryPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", parentId);
            ProductCategoryPO parentCategory = productCategoryMapper.selectOne(queryWrapper);
            
            if (parentCategory == null) {
                throw new BusinessException(1_008_001_001, "父分类不存在");
            }

            // 根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L）
            // 如果父分类的parentId不为0，说明它不是一级分类
            if (!parentCategory.getParentId().equals(0L)) {
                throw new BusinessException(1_008_001_002, "父分类不能是二级分类");
            }
        }
        
        // 校验分类名称是否为空
        if (createProductCategoryDTO.getName() == null || createProductCategoryDTO.getName().trim().isEmpty()) {
            throw new BusinessException(1_008_001_005, "分类名称不能为空");
        }
        
        // 校验移动端分类图是否为空
        if (createProductCategoryDTO.getPicUrl() == null || createProductCategoryDTO.getPicUrl().trim().isEmpty()) {
            throw new BusinessException(1_008_001_006, "移动端分类图不能为空");
        }
        
        // 校验分类排序是否为空
        if (createProductCategoryDTO.getSort() == null) {
            throw new BusinessException(1_008_001_007, "分类排序不能为空");
        }
        
        // 校验开启状态是否为空
        if (createProductCategoryDTO.getStatus() == null) {
            throw new BusinessException(1_008_001_008, "开启状态不能为空");
        }
    }

    /**
     * 校验更新商品分类的参数
     *
     * @param productCategory 商品分类实体
     */
    private void validateUpdateParams(ProductCategoryPO productCategory) {
        // 根据传入的更新商品分类-请求参数(Body)-分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验分类编号是否真实存在
        if (productCategory.getId() == null || productCategory.getId() <= 0) {
            throw new BusinessException(1_008_001_000, "商品分类不存在");
        }

        // 查询原分类信息
        ProductCategoryPO existingCategory = productCategoryMapper.selectById(productCategory.getId());
        if (existingCategory == null) {
            throw new BusinessException(1_008_001_000, "商品分类不存在");
        }

        Long parentId = productCategory.getParentId();

        // 若传入的父分类编号为根分类默认标识（值为0L），直接跳过校验
        if (parentId != null && !parentId.equals(0L)) {
            // 根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类是否真实存在
            ProductCategoryPO parentCategory = productCategoryMapper.selectById(parentId);
            
            if (parentCategory == null) {
                throw new BusinessException(1_008_001_001, "父分类不存在");
            }

            // 根据传入的父分类编号使用商品分类(mapper)的数据库操作对象查询数据库校验父分类必须是一级分类（值为0L）
            // 如果父分类的parentId不为0，说明它不是一级分类
            if (!parentCategory.getParentId().equals(0L)) {
                throw new BusinessException(1_008_001_002, "父分类不能是二级分类");
            }
        }

        // 防止将分类更新为其自身的子分类
        if (parentId != null && parentId.equals(existingCategory.getId())) {
            throw new BusinessException(1_008_001_004, "父分类不能是自身");
        }
    }

    /**
     * 检查同名分类是否存在
     *
     * @param name     分类名称
     * @param parentId 父分类编号
     */
    private void checkDuplicateName(String name, Long parentId) {
        ProductCategoryPO existingCategory = productCategoryMapper.selectByNameAndParentId(name, parentId);
        if (existingCategory != null) {
            throw new BusinessException(1_008_001_009, "同名分类已存在");
        }
    }
}