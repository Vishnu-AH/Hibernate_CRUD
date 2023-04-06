package com.pace.hibernate.utility;

import com.pace.hibernate.ApiSuccess;
import org.springframework.http.ResponseEntity;

public class CommonUtil {
    public static ResponseEntity<Object> buildResponse(ApiSuccess apiSuccess){
        return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
    }
}
