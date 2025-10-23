package org.example.productservice.products.domain.exception;

public class CouldNotFindProductException extends RuntimeException {

    public CouldNotFindProductException(String message) {
        super(message);
    }

    public CouldNotFindProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
