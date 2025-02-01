package com.dal.assignment2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Main class to read Reuters data from a file, parse articles, clean text, and insert into MongoDB.
 */
public class ReutReader {
    //Add the VM Options -Djdk.tls.client.protocols=TLSv1.2
    // to make this mongo compatible with java 11
    // (the issue doesn't exist in version >jdk 13.0.5)
    private static final String CONNECTION_STRING = "mongodb+srv://himanshi:himanshi123@mymongocluster.lwvnepl.mongodb.net/ReuterDb";
    private static final String MONGO_COLLECTION = "news";
    private static final String FILE_NAME = "reut2-009.sgm";

    /**
     * Main method to execute the process of reading, parsing, cleaning, and inserting Reuters articles into MongoDB.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {

            // Read the contents of the Reuters data file into a string variable
            String fileContent = Files.readString(Paths.get(FILE_NAME));

            ReuterArticleParser articleParser = new ReuterArticleParser();
            List<NewsArticle> articles = articleParser.parseArticles(fileContent);
            System.out.println("Number of articles parsed is -"+articles.size());

            // Connect to the existing MongoDB database using connection URL
            MongoNewsConnector newsConnector = new MongoNewsConnector(CONNECTION_STRING, MONGO_COLLECTION);

            // Iterate over each cleaned title and its corresponding body
            System.out.println("Inserting into mongo db... Please wait !");
            for (NewsArticle article : articles) {
                TextCleaner textCleaner = new TextCleaner();
                String cleanedTitle = textCleaner.cleanText(article.getTitle());
                String cleanedBody = textCleaner.cleanText(article.getBody());
                article.setTitle(cleanedTitle);
                article.setBody(cleanedBody);
                newsConnector.insertDocument(article.toDocument());
            }
            System.out.println("Successfully Inserted into mongoDb");
        } catch (Exception e) {
            System.out.println("Exception occurred");
            e.printStackTrace();
        }
    }
}
