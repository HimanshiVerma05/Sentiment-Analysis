package com.dal.assignment2;

import java.io.IOException;
import java.util.List;

/**
 * Main class responsible for coordinating sentiment analysis of news titles.
 */
public class Problem3 {
    private static final String CONNECTION_STRING = "mongodb+srv://himanshi:himanshi123@mymongocluster.lwvnepl.mongodb.net/";
    private static final String MONGO_COLLECTION = "news";
    private static final String MONGO_DATABASE_NAME = "ReuterDb";
    /**
     * Main method to execute the sentiment analysis process.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            MongoDBConnection connection = new MongoDBConnection(CONNECTION_STRING, MONGO_DATABASE_NAME, MONGO_COLLECTION);
            List<String> newsTitles = connection.fetchNewsTitles();
            SentimentAnalyzer analyzer = new SentimentAnalyzer("positive_words.txt", "negative_words.txt");
            SentimentAnalysisResult result = analyzer.analyzeSentiments(newsTitles);

            CSVWriter writer = new CSVWriter("news_sentiment_analysis.csv");
            writer.writeResults(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}