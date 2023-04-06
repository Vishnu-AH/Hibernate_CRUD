package org.example.exceptions;

public class ClassCast {
    public static void main(String[] args) {
        try {
            Office office = new Office();
            Employee employee = (Employee) office; // Downcasting

            Office office1 = new Manager();
            Employee employee1 = (Employee) office1; // Downcasting
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught!");
        }

    }
}
class Office {

}

class Employee extends Office {

}

class Manager extends Office {

}
