package com.assignment.books.exception;

import com.assignment.books.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        log.error("[Method Argument Not Valid] Error: {}", exception.getMessage(), exception);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse.methodArgumentNotValid(exception));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<BaseResponse<Void>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        log.error("[Method Argument Type Mismatch] Error: {}", exception.getMessage(), exception);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse.methodArgumentTypeMismatch());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseResponse<Void>> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        log.error("[Http Message Not Readable] Error: {}", exception.getMessage(), exception);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse.httpMessageNotReadable());
    }
}


