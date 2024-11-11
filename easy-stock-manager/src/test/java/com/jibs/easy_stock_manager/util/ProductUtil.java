package com.jibs.easy_stock_manager.util;

import com.jibs.easy_stock_manager.domain.model.ProductModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductUtil {

    public static final ProductModel PRODUCT =  ProductModel.builder()
            .name("Sample Product")
            .price(BigDecimal.valueOf(33.88))
            .quantity(10)
            .usedQuantity(2)
            .description("A sample product description")
            .reviewStars(5)
            .purchaseDate(LocalDate.now().minusDays(5))
            .expiryDate(LocalDate.now().plusDays(30))
            .storeName("Sample Store")
            .category("Sample Category")
            .build();
}
