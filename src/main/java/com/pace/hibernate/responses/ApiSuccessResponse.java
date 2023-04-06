package com.pace.hibernate.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiSuccessResponse {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private Object data;

    private ApiSuccessResponse() {
        timestamp = LocalDateTime.now();
    }
    public ApiSuccessResponse(HttpStatus status) {
        this();
        this.status = status;
    }
    public ApiSuccessResponse(HttpStatus status, Object object) {
        this();
        this.status = status;
        this.data = object;
    }
}
