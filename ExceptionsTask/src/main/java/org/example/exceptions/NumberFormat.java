package org.example.exceptions;

public class NumberFormat {
    public static void main(String[] args){
        try{
            int a = Integer.parseInt(null);
        }
        catch(ArithmeticException exception){
            System.out.println("Arithmetic Exception caught");
        }
        catch(NumberFormatException exception){
            System.out.println("Number format exception caught");
        }
        finally {
            System.out.println("Execution terminated smoothly");
        }
    }
}
