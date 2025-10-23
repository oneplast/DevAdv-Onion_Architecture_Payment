package org.example.productservice.products.infrastructure.mapper;

import org.example.productservice.products.domain.model.Product;
import org.example.productservice.products.domain.vo.ProductSpecification;
import org.example.productservice.products.infrastructure.model.dto.ProductDescription;
import org.example.productservice.products.infrastructure.model.persistence.ProductEntity;
import org.example.productservice.products.infrastructure.model.web.ProductSpecificationRequest;

public class ProductMapper {
    public static ProductEntity toEntity(Product domain) {
        ProductSpecification specification = domain.getSpecification();

        return ProductEntity.builder()
                .code(domain.getCode())
                .name(specification.name())
                .description(specification.description())
                .price(specification.price())
                .build();
    }

    public static void applyToEntity(Product domain, ProductEntity entity) {
        ProductSpecification specification = domain.getSpecification();

        entity.setName(specification.name());
        entity.setDescription(specification.description());
        entity.setPrice(specification.price());

        entity.updateClock();
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getCode(),
                new ProductSpecification(entity.getName(), entity.getDescription(), entity.getPrice()),
                entity.getCreatedTime(),
                entity.getUpdatedAt());
    }

    public static ProductSpecification toSpecification(ProductSpecificationRequest request) {
        return new ProductSpecification(request.name(), request.description(), request.price());
    }

    public static ProductDescription toDescription(Product domain) {
        return new ProductDescription(domain.getCode(),
                domain.getSpecification().name(),
                domain.getSpecification().description(),
                domain.getSpecification().price());
    }
}
