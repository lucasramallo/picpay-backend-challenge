package com.github.lucasramallo.project.core.domain.customer.exceptions;

public class InvalidCustomerException extends RuntimeException{
    public InvalidCustomerException(String message) {
        super(message);
    }
}
