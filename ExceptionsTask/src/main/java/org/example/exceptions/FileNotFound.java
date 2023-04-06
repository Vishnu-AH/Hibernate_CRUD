package org.example.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFound {
    public static void fileRead() throws IOException {
        FileReader fileReader = new FileReader("Test.txt");
        System.out.println(fileReader.read());
        fileReader.close();
    }
    public static void main(String[] args) {
        try{
            fileRead();
        }
        catch(FileNotFoundException exception){
            System.out.println("File not found exception caught");
        }
        catch(IOException exception){
            System.out.println("IO Exception Caught");
        }
    }
}
