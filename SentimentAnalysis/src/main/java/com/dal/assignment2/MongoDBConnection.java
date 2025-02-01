package com.dal.assignment2;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public /**
 * Class responsible for establishing connection to MongoDB and fetching news titles.
 */
class MongoDBConnection {
    private final String uri;
    private final String databaseName;
    private final String collectionName;

    /**
     * Constructor for MongoDBConnection class.
     *
     * @param uri            MongoDB connection URI.
     * @param databaseName   Name of the database.
     * @param collectionName Name of the collection.
     */
    public MongoDBConnection(String uri, String databaseName, String collectionName) {
        this.uri = uri;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
    }

    /**
     * Fetches news titles from MongoDB database.
     *
     * @return List of news titles.
     */
    public List<String> fetchNewsTitles() {
        System.out.println("Fetching newsTitles from mongodb");
        List<String> newsTitles = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> documents = collection.find();
            documents.iterator().forEachRemaining(doc -> newsTitles.add(doc.getString("title")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Number of newsTitles fetched are - "+newsTitles.size());
        return newsTitles;
    }

}