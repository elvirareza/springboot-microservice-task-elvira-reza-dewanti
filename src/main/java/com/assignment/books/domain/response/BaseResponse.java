package com.assignment.books.domain.response;

import com.assignment.books.domain.constant.ResponseMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private String message;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
            .message(ResponseMessage.SUCCESS)
            .data(data)
            .build();
    }

    public static <T> BaseResponse<T> dataNotFound(String message) {
        return BaseResponse.<T>builder()
            .message(String.format(ResponseMessage.DATA_NOT_FOUND_WITH_PARAMETER, message))
            .data(null)
            .build();
    }

    public static BaseResponse<String> methodArgumentNotValid(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.joining(", "));

        return BaseResponse.<String>builder()
            .message(ResponseMessage.INVALID_REQUEST)
            .data(message)
            .build();
    }

    public static <T> BaseResponse<T> methodArgumentTypeMismatch() {
        return BaseResponse.<T>builder()
            .message(ResponseMessage.INVALID_PARAMETER)
            .data(null)
            .build();
    }

    public static <T> BaseResponse<T> httpMessageNotReadable() {
        return BaseResponse.<T>builder()
            .message(ResponseMessage.INVALID_REQUEST)
            .data(null)
            .build();
    }
}
