package org.example.productservice.products.domain.vo.pagination;

public record SortSpec(
        String property,
        Direction direction
) {
    public enum Direction {
        ASC, DESC
    }
}
