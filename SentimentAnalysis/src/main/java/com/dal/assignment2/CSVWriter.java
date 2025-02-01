package com.dal.assignment2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class responsible for writing results to a CSV file.
 */
public class CSVWriter {
    private final String filePath;

    /**
     * Constructor for CSVWriter class.
     *
     * @param filePath Path to the CSV file.
     */
    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the results of sentiment analysis to the CSV file.
     *
     * @param result Result of sentiment analysis.
     * @throws IOException If an I/O error occurs.
     */
    public void writeResults(SentimentAnalysisResult result) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            System.out.println("Writing the result in a csv file");
            writer.write("News#,Title,Match,Score,Polarity\n"); // Header row
            for (int i = 0; i < result.getNewsTitles().size(); i++) {

                writer.write((i + 1) + "," +
                        result.getNewsTitles().get(i) + "," +
                        result.getMatches().get(i) + "," +
                        result.getScores().get(i) + "," +
                        result.getPolarities().get(i) + "\n");
            }
            writer.flush(); // Explicitly flush the BufferedWriter
            System.out.println("Results written to csv file - " + filePath);
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}