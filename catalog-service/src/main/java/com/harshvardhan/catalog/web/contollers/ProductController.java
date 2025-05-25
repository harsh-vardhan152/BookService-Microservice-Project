package com.harshvardhan.catalog.web.contollers;

import com.harshvardhan.catalog.domain.*;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PageResult<ClientProductEntity> getProducts(@RequestParam(name = "page",defaultValue = "1") int pageNo) {
        // Call the service method to get paginated products
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<ClientProductEntity> getProductByCode(@PathVariable String code) {
        // Call the service method to get a product by its code
        return productService.getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }


}
