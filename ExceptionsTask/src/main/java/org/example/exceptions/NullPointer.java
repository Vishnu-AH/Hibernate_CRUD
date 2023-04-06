package org.example.exceptions;

public class NullPointer {
    int a=10;
}
class Example{
    public static void main(String [] args){
        NullPointer nullPointer = null;
        try{
            System.out.println(nullPointer.a);
        }
        catch(NullPointerException exception){
            System.out.println("Reference pointing to null");
        }
    }
}
