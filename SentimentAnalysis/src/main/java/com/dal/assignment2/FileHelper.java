package com.dal.assignment2;

import java.io.IOException;
import java.util.List;

/**
 * Helper class for reading lines from a file.
 */
public class FileHelper {
    /**
     * Reads lines from a file.
     *
     * @param filePath Path to the file.
     * @return List of lines read from the file.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> readLines(String filePath) throws IOException {
        return java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filePath));
    }
}
