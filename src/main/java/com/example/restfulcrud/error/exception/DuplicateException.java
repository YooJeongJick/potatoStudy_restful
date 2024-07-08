package com.example.restfulcrud.error.exception;

import com.example.restfulcrud.error.ErrorCode;

public class DuplicateException extends BusinessException{
    public DuplicateException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
