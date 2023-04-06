package org.example.exceptions;

public class ArrayIndex {
    public static void main(String [] args){
        int [] array = new int[5];
        try{
            for(int i=0;i<=array.length;i++){
                array[i]=i;
            }
        }
        catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("Index out of bound");
        }
    }
}
