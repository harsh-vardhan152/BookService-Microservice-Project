package com.harshvardhan.catalog.domain;

import com.harshvardhan.catalog.ApplicationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Transactional
//@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;
    private final ApplicationProperties applicationProperties;

    ProductService(ProductRepository productRepository, ApplicationProperties applicationProperties) {
        this.productRepository = productRepository;
        this.applicationProperties = applicationProperties;
    }

    // This method retrieves a paginated list of products from the repository.
    public PageResult<ClientProductEntity> getProducts(int pageNo) {

        // Default sort by name in ascending order
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        // If pageNo is less than or equal to 1, set it to 0 (first page)
        pageNo = pageNo <= 1 ? pageNo = 0 : pageNo - 1;

        // Create a Pageable object with the specified page number, size, and sort order
        Pageable pageable = PageRequest.of(pageNo,applicationProperties.pageSize(), sort);

        // Fetch the paginated products from the repository
        Page<ClientProductEntity> productEntities = productRepository.findAll(pageable)
                .map(ProductMapper::toProduct);

        // Return a PageResult object containing the products and pagination details
        return new PageResult<>(
                productEntities.getContent(),
                productEntities.getTotalElements(),
                productEntities.getNumber()+1,
                productEntities.getTotalPages(),
                productEntities.isFirst(),
                productEntities.isLast(),
                productEntities.hasNext(),
                productEntities.hasPrevious()
        );
    }

    public Optional<ClientProductEntity> getProductByCode(String code) {
        return productRepository.findByCode(code)
                .map(ProductMapper::toProduct);
    }
}
