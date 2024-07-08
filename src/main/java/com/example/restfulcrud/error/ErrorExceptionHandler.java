package com.example.restfulcrud.error;

import com.example.restfulcrud.error.exception.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorExceptionHandler {
    @ExceptionHandler({DuplicateException.class})
    public ResponseEntity<ErrorEntity> exceptionHandler(final DuplicateException e) {
        ErrorEntity errorEntity = ErrorEntity.builder()
                .errorCode(Integer.parseInt(e.getErrorCode().getCode()))
                .errorMessage(e.getMessage())
                .build();
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(errorEntity);
    }
}
