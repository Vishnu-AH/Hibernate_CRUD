package com.pace.hibernate.responses;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private String message;
    private int httpStatus;
    private Object data;

    public ApiErrorResponse() {
    }
}
