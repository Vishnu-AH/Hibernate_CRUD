package org.example.exceptions;

public class StringIndexOutOfBounds {
    public static void main(String[] args) {
        String str = "pace wisdom";
        System.out.println("Length of the String: "+str.length());
        try{
            for(int i=0; i<str.length(); i++) {
                System.out.print(str.charAt(i)+" ");
            }
            System.out.println(str.charAt(11));
        }
        catch(StringIndexOutOfBoundsException exception){
            System.out.println("\nStringIndexOutOfBoundsException caught");
        }
    }
}
