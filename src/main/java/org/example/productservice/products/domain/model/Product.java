package org.example.productservice.products.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import org.example.productservice.products.domain.vo.ProductSpecification;

public class Product {
    private String code;

    private ProductSpecification specification;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String code, ProductSpecification specification, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code = code;
        this.specification = specification;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void changeSpecification(ProductSpecification newSpec) {
        validate(newSpec);

        this.specification = newSpec;
        this.updatedAt = LocalDateTime.now();
    }

    public Product(ProductSpecification specification) {
        validate(specification);
        this.specification = specification;

        this.code = genCode();

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    private void validate(ProductSpecification specification) {
        if (specification.name().isBlank()) {
            throw new IllegalArgumentException("제품명은 반드시 입력되어야 합니다.");
        }

        if (specification.description().isBlank()) {
            throw new IllegalArgumentException("제품 설명은 반드시 입력되어야 합니다.");
        }

        if (specification.price() <= 0) {
            throw new IllegalArgumentException("가격은 반드시 0원 이상이거나 양수여야 합니다.");
        }
    }

    public String genCode() {
        return UUID.randomUUID().toString();
    }

    public String getCode() {
        return code;
    }

    public ProductSpecification getSpecification() {
        return specification;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
