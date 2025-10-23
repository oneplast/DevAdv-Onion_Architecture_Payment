package org.example.productservice.products.application.adapter;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.productservice.products.application.port.in.ProductCrudUseCase;
import org.example.productservice.products.application.port.out.ProductPersistencePort;
import org.example.productservice.products.domain.exception.CouldNotFindProductException;
import org.example.productservice.products.domain.model.Product;
import org.example.productservice.products.domain.vo.ProductSpecification;
import org.example.productservice.products.domain.vo.pagination.PageQuery;
import org.example.productservice.products.domain.vo.pagination.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductApplication implements ProductCrudUseCase {

    private final ProductPersistencePort productPort;

    @Override
    @Transactional
    public Product enroll(ProductSpecification specification) {
        Product product = new Product(specification);
        return productPort.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductByCode(String code) {
        return productPort.getProductByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResult<Product> findAll(PageQuery pageQuery) {
        return productPort.findAll(pageQuery);
    }

    @Override
    @Transactional
    public Product updateSpecification(String code, ProductSpecification specification) {
        Product product = getProductByCode(code).orElseThrow(
                () -> new CouldNotFindProductException("해당 상품을 찾을 수가 없습니다."));

        product.changeSpecification(specification);
        return productPort.save(product);
    }
}
