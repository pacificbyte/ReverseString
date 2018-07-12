package com.test.file;

import com.test.file.handler.FileHandler;

public class Main {

    public static void main(String[] args) {
       String filename = "filename.txt";
       FileHandler handler = new FileHandler(filename);
       
       handler.createFile();
       handler.readFile();
       handler.writeReversedFile();
    }

}
