package org.example.exceptions;

public class Arithmetic {
    public  static void main(String[] args){
        try{
            System.out.println(1/0);
        }
        catch (ArithmeticException exception){
            System.out.println("Divide by zero...!!");
        }
    }
}
