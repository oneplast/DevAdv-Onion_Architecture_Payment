package org.example.productservice.products.domain.vo.pagination;

public record PageQuery(
        int page,
        int size,
        SortSpec sort
) {
}
