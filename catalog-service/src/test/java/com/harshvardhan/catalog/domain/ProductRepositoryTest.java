package com.harshvardhan.catalog.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


//Slice test for JPA repositories
@DataJpaTest(
    properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///db",
    })
@Sql("/test-data.sql")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldGetAllProducts(){
        List<ProductEntity> productEntities= productRepository.findAll();
        assertThat(productEntities).hasSize(15);
    }

    @Test
    void ShouldGetProductByCode() {
        String productCode = "P0001";
        Optional<ProductEntity> productEntity = productRepository.findByCode(productCode);
        assertThat(productEntity).isPresent();
        assertThat(productEntity.get().getCode()).isEqualTo(productCode);
    }

}