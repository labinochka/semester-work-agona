package com.technokratos.exception;

import org.springframework.http.HttpStatus;

public class NotUpdateServiceException extends ServiceException {

    public NotUpdateServiceException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
