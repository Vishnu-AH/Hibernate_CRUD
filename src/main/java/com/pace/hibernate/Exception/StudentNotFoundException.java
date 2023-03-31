package com.pace.hibernate.Exception;

public class StudentNotFoundException extends RuntimeException{
    private String message;
    StudentNotFoundException(){
    }
    public StudentNotFoundException(String message){
        this.message=message;
    }
}
