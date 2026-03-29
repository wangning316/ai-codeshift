package com.github.product.service.impl;

import com.github.product.controller.vo.GetProductCategoryListReqVO;
import com.github.product.controller.vo.GetProductCategoryListRespVO;
import com.github.product.entity.po.ProductCategory;
import com.github.product.mapper.ProductCategoryListMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductCategoryListServiceImplTest {

    @Mock
    private ProductCategoryListMapper productCategoryListMapper;

    @InjectMocks
    private ProductCategoryListServiceImpl productCategoryListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductCategoryList() {
        // 准备测试数据
        ProductCategory category1 = new ProductCategory();
        category1.setId(1L);
        category1.setParentId(0L);
        category1.setName("电子产品");
        category1.setSort(1);
        category1.setStatus(1);
        category1.setCreateTime(LocalDateTime.now());

        ProductCategory category2 = new ProductCategory();
        category2.setId(2L);
        category2.setParentId(1L);
        category2.setName("手机");
        category2.setSort(1);
        category2.setStatus(1);
        category2.setCreateTime(LocalDateTime.now());

        when(productCategoryListMapper.selectList(any())).thenReturn(Arrays.asList(category1, category2));

        // 准备请求参数
        GetProductCategoryListReqVO reqVO = new GetProductCategoryListReqVO();
        
        // 执行测试
        List<GetProductCategoryListRespVO> result = productCategoryListService.getProductCategoryList(reqVO);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.size()); // 只有根节点会出现在顶层
        assertEquals("电子产品", result.get(0).getName());
        assertNotNull(result.get(0).getChildren());
        assertEquals(1, result.get(0).getChildren().size());
        assertEquals("手机", result.get(0).getChildren().get(0).getName());
    }
    
    @Test
    void testGetProductCategoryListWithFilters() {
        // 准备测试数据
        ProductCategory category1 = new ProductCategory();
        category1.setId(1L);
        category1.setParentId(0L);
        category1.setName("电子产品");
        category1.setSort(1);
        category1.setStatus(1);
        category1.setCreateTime(LocalDateTime.now());

        when(productCategoryListMapper.selectList(any())).thenReturn(Arrays.asList(category1));

        // 准备请求参数
        GetProductCategoryListReqVO reqVO = new GetProductCategoryListReqVO();
        reqVO.setParentId(0L);
        reqVO.setName("电子");
        reqVO.setStatus(1);
        
        // 执行测试
        List<GetProductCategoryListRespVO> result = productCategoryListService.getProductCategoryList(reqVO);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("电子产品", result.get(0).getName());
    }
}