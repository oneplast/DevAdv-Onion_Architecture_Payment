package org.example.productservice.products.infrastructure.adapter.in.web;

public record BaseResponse<T>(
        T data,
        String message
) {
}
