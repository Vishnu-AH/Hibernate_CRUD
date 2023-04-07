package com.pace.hibernate.Exception;

import com.pace.hibernate.responses.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<Object> schoolNotFoundExceptionHandlerEntity(SchoolNotFoundException ex){
        ApiErrorResponse response = new ApiErrorResponse();
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND.value());
        response.setData("No data found for given ID");
        return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotFoundExceptionHandlerEntity(StudentNotFoundException ex){
        ApiErrorResponse response = new ApiErrorResponse();
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND.value());
        response.setData("No data found for given ID");
        return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
    }

}
