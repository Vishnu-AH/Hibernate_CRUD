package org.example.exceptions;

public class ClassNotFound {
    public static void main(String[] args) {
        try {
            Class.forName("com.journaldev.MyInvisibleClass");

            ClassLoader.getSystemClassLoader().loadClass("com.journaldev.MyInvisibleClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught");
        }
    }
}
