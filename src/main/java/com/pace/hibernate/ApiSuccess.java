package com.pace.hibernate;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiSuccess {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private Object data;

    private ApiSuccess() {
        timestamp = LocalDateTime.now();
    }
    public ApiSuccess(HttpStatus status) {
        this();
        this.status = status;
    }
    public ApiSuccess(HttpStatus status, Object object) {
        this();
        this.status = status;
        this.data = object;
    }
}
