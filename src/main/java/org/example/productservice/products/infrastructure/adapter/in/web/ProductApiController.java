package org.example.productservice.products.infrastructure.adapter.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.productservice.products.application.port.in.ProductCrudUseCase;
import org.example.productservice.products.domain.vo.ProductSpecification;
import org.example.productservice.products.infrastructure.mapper.ProductMapper;
import org.example.productservice.products.infrastructure.model.dto.ProductDescription;
import org.example.productservice.products.infrastructure.model.web.ProductSpecificationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductCrudUseCase productCrudUseCase;

    @PostMapping
    public BaseResponse<ProductDescription> createProduct(@RequestBody @Valid ProductSpecificationRequest request) {
        ProductSpecification specification = ProductMapper.toSpecification(request);

        return new BaseResponse<>(ProductMapper.toDescription(productCrudUseCase.enroll(specification)), "");
    }
}
