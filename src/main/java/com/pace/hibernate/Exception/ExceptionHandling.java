package com.pace.hibernate.Exception;

import com.pace.hibernate.model.School;
import com.pace.hibernate.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<Response<String>> schoolNotFoundExceptionHandlerEntity(SchoolNotFoundException ex){
        Response<String> response = new Response<>();
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND.value());
        response.setData("No data found for given ID");
        return new ResponseEntity<Response<String>>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Response<String>> studentNotFoundExceptionHandlerEntity(StudentNotFoundException ex){
        Response<String> response = new Response<>();
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND.value());
        response.setData("No data found for given ID");
        return new ResponseEntity<Response<String>>(response,HttpStatus.NOT_FOUND);
    }
}
