package org.example.productservice.products.infrastructure.model.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Long price;

    private LocalDateTime createdTime = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public ProductEntity(String code, String name, String description, Long price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void updateClock() {
        this.updatedAt = LocalDateTime.now();
    }
}
