package com.harshvardhan.catalog.domain;

import java.math.BigDecimal;

public record ClientProductEntity(
        String code,
        String name,
        String description,
        String imageUrl,
        BigDecimal price) {
}
