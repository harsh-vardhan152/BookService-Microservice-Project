package com.harshvardhan.catalog.domain;

public class ProductNotFoundException extends RuntimeException {


    public ProductNotFoundException(String s) {
        super(s);
    }

    public static ProductNotFoundException forCode (String code) {
        return new ProductNotFoundException("Product not found with code: " + code);
    }
}
