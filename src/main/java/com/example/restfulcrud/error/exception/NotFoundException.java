package com.example.restfulcrud.error.exception;

import com.example.restfulcrud.error.ErrorCode;

public class NotFoundException extends BusinessException{
    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
