package com.jibs.easy_stock_manager.domain.exception;

public class DuplicateProductNameException extends RuntimeException {

    public DuplicateProductNameException(String message) {
        super(message);
    }

}
