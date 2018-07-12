package com.test.file.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());

    String filename;
    List<String> lines;

    public FileHandler(String filename) {
        super();
        this.filename = filename;
    }

    public void createFile() {
        StringBuilder lines = new StringBuilder();
        lines.append("The first line");
        lines.append("\n");
        lines.append("The second line");
        lines.append("\n");
        lines.append("I have a dream");
        this.printLines(lines.toString(), this.filename);
    }

    private void printLines(String lines, String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename, StandardCharsets.UTF_8.toString());
            writer.println(lines);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            LOGGER.log(Level.FINE, "Error when creating the file", e);
        }
    }

    public void readFile() {
        lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error when reading the file", e);
        }
    }

    public void writeReversedFile() {
        StringBuilder reversedLines = new StringBuilder();
        String reversedFilename = "reversedFilename";
        
        if(lines != null) {
            for(String line : lines) {
                String[] words = line.split("\\s+");
                for(int i = words.length - 1; i >= 0; i--) {
                    reversedLines.append(words[i]);
                    reversedLines.append(" ");
                }
                reversedLines.append("\n");
            }
            this.printLines(reversedLines.toString(), reversedFilename);
        }
    }

}
