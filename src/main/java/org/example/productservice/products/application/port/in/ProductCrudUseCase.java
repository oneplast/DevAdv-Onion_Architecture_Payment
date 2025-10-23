package org.example.productservice.products.application.port.in;

import java.util.Optional;
import org.example.productservice.products.domain.model.Product;
import org.example.productservice.products.domain.vo.ProductSpecification;
import org.example.productservice.products.domain.vo.pagination.PageQuery;
import org.example.productservice.products.domain.vo.pagination.PageResult;

public interface ProductCrudUseCase {

    Product enroll(ProductSpecification specification);

    Optional<Product> getProductByCode(String code);

    PageResult<Product> findAll(PageQuery pageQuery);

    Product updateSpecification(String code, ProductSpecification specification);
}
