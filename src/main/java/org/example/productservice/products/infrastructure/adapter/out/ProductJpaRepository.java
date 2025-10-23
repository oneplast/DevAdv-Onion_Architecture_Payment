package org.example.productservice.products.infrastructure.adapter.out;

import java.util.Optional;
import org.example.productservice.products.infrastructure.model.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);
}
