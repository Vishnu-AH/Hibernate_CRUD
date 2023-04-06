package org.example.exceptions;

public class IllegalArgument {
    int m;
    public void setMarks(int marks) {
        if(marks < 0 || marks > 100)
            throw new IllegalArgumentException(Integer.toString(marks));
        else{
            m = marks;
            System.out.println(m);
        }
    }
    public static void main(String[] args) {
        IllegalArgument a = new IllegalArgument();
        IllegalArgument a1 = new IllegalArgument();
        try{
            a.setMarks(45);
            a1.setMarks(101);
        }catch (IllegalArgumentException exception){
            System.out.println("Illegal Argument exception caught");
        }
    }
}