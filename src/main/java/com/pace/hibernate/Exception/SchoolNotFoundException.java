package com.pace.hibernate.Exception;

import lombok.Data;

@Data
public class SchoolNotFoundException extends RuntimeException{
    private String message;
    public SchoolNotFoundException(){
    }
    public SchoolNotFoundException(String message){
        this.message=message;
    }
}
