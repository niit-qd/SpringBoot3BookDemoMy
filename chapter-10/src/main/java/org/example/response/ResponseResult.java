package org.example.response;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;
}
