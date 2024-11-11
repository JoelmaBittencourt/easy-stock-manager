package com.jibs.easy_stock_manager.domain.model;


import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record ProductModel(
        String name,
        BigDecimal price,
        int quantity,
        int usedQuantity,
        String description,
        String marca,
        String additionalInfo,
        int reviewStars,
        LocalDate purchaseDate,
        LocalDate expiryDate,
        boolean open,
        String storeName,
        String category,
        String subCategory,
        String room,
        String specificLocation
) {
}

