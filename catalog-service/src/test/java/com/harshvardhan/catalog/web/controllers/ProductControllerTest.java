package com.harshvardhan.catalog.web.controllers;

import com.harshvardhan.catalog.AbstractIT;
import com.harshvardhan.catalog.domain.ClientProductEntity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@Sql("/test-data.sql")
class ProductControllerTest extends AbstractIT {



    @Test
    void shouldReturnProducts() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/products")
                .then()
                .statusCode(200)
                .body("data", hasSize(10))
                .body("totalElements", is(15))
                .body("pageNumber", is(1))
                .body("totalPages", is(2))
                .body("isFirstPage", is(true))
                .body("isLastPage", is(false))
                .body("hasNextPage", is(true))
                .body("hasPreviousPage", is(false));
    }

    @Test
    void shouldGetProductByCode(){
        ClientProductEntity product = given().contentType(ContentType.JSON)
                .when()
                .get("/api/products/{code}", "P100")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(ClientProductEntity.class);

        assertThat(product.code()).isEqualTo("P100");
        assertThat(product.name()).isEqualTo("The Hunger Games");
        assertThat(product.price()).isEqualTo(new BigDecimal("34.0"));
        assertThat(product.description()).isEqualTo("Winning will make you famous. Losing means certain death...");
    }

    @Test
    void shouldReturnNotFoundWhenProductCodeNotExists(){
        String code = "invalid_product_code";
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/products/{code}", code)
                .then()
                .statusCode(404)
                .body("status", is(404))
                .body("title", is("Product Not Found"))
                .body("detail", is("Product not found with code: " + code));
    }
}