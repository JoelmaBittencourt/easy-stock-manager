package com.jibs.easy_stock_manager.infrastructure.resource.request;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductRequest(
        String name,
        BigDecimal price,
        int quantity,
        int usedQuantity,
        String description,
        int reviewStars,
        String marca,
        String subCategory,
        String additionalInfo,
        boolean open,
        LocalDate purchaseDate,
        LocalDate expiryDate,
        String storeName,
        String category,
        String room,
        String specificLocation
) {
}
