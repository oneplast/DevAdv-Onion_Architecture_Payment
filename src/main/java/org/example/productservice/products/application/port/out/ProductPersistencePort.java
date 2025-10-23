package org.example.productservice.products.application.port.out;

import java.util.Optional;
import org.example.productservice.products.domain.model.Product;
import org.example.productservice.products.domain.vo.pagination.PageQuery;
import org.example.productservice.products.domain.vo.pagination.PageResult;

public interface ProductPersistencePort {

    Product save(Product product);

    Optional<Product> getProductByCode(String code);

    PageResult<Product> findAll(PageQuery pageQuery);
}
