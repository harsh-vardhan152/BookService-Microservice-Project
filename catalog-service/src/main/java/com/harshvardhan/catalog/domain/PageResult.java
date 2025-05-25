package com.harshvardhan.catalog.domain;

import java.util.List;

public record PageResult<T>(
        List<T> data,
        Long totalElements,
        int pageNumber,
        int totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        boolean hasNextPage,
        boolean hasPreviousPage
        ) {}