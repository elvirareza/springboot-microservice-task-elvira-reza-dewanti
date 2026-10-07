package com.assignment.books.domain.response;

import com.assignment.books.domain.constant.ResponseMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
}
