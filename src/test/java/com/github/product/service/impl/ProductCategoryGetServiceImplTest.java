package com.github.product.service.impl;

import com.github.product.mapper.ProductCategoryGetMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

class ProductCategoryGetServiceImplTest {

    @Mock
    private ProductCategoryGetMapper productCategoryGetMapper;

    @InjectMocks
    private ProductCategoryGetServiceImpl productCategoryGetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}