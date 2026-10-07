package com.assignment.books.exception;

import com.assignment.books.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<BaseResponse<Void>> handleDataNotFound(DataNotFoundException exception) {
        log.error("[Data Not Found] Error: {}", exception.getMessage(), exception);
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(BaseResponse.dataNotFound(exception.getMessage()));
    }
}


