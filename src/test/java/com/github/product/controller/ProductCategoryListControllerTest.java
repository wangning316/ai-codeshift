package com.github.product.controller;

import com.github.product.controller.vo.GetProductCategoryListReqVO;
import com.github.product.controller.vo.GetProductCategoryListRespVO;
import com.github.product.service.ProductCategoryListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductCategoryListController.class)
class ProductCategoryListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductCategoryListService productCategoryListService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetProductCategoryList() throws Exception {
        // 准备测试数据
        GetProductCategoryListRespVO category1 = new GetProductCategoryListRespVO();
        category1.setId(1L);
        category1.setParentId(0L);
        category1.setName("电子产品");
        category1.setSort(1);
        category1.setStatus(1);

        GetProductCategoryListRespVO category2 = new GetProductCategoryListRespVO();
        category2.setId(2L);
        category2.setParentId(1L);
        category2.setName("手机");
        category2.setSort(1);
        category2.setStatus(1);

        List<GetProductCategoryListRespVO> categories = Arrays.asList(category1, category2);
        
        when(productCategoryListService.getProductCategoryList(any(GetProductCategoryListReqVO.class)))
                .thenReturn(categories);

        // 执行测试
        mockMvc.perform(get("/product/category/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.length()").value(2));
    }

    @Test
    void testGetProductCategoryListWithFilters() throws Exception {
        // 准备测试数据
        GetProductCategoryListRespVO category = new GetProductCategoryListRespVO();
        category.setId(1L);
        category.setParentId(0L);
        category.setName("电子产品");
        category.setSort(1);
        category.setStatus(1);

        List<GetProductCategoryListRespVO> categories = Arrays.asList(category);
        
        when(productCategoryListService.getProductCategoryList(any(GetProductCategoryListReqVO.class)))
                .thenReturn(categories);

        // 执行测试
        mockMvc.perform(get("/product/category/list")
                .param("parentId", "0")
                .param("name", "电子")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.length()").value(1))
                .andExpect(jsonPath("$.data[0].name").value("电子产品"));
    }
}