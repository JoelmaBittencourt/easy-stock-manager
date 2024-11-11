package com.jibs.easy_stock_manager.infrastructure.resource.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductResponse(
        String name,
        BigDecimal price,
        int quantity,
        int usedQuantity,
        String description,
        String subCategory,
        String additionalInfo,

        boolean open,
        String marca,
        int reviewStars,
        LocalDate purchaseDate,
        LocalDate expiryDate,
        String storeName,
        String category,
        String room,
        String specificLocation
) {
}
