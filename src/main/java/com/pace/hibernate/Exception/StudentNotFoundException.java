package com.pace.hibernate.Exception;

import lombok.Data;

@Data
public class StudentNotFoundException extends RuntimeException{
    private String message;
    public StudentNotFoundException(){
    }
    public StudentNotFoundException(String message){
        this.message=message;
    }
}
