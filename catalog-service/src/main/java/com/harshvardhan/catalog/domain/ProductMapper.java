package com.harshvardhan.catalog.domain;

class ProductMapper {

    static ClientProductEntity toProduct(ProductEntity productEntity) {
        return new ClientProductEntity(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice()
        );
    }
}
