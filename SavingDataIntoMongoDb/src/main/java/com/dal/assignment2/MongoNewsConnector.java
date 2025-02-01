package com.dal.assignment2;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Class responsible for interacting with MongoDB.
 */
public class MongoNewsConnector {
    private MongoDatabase mongoDatabase;
    private String collectionName;

    /**
     * Constructs a new MongoNewsConnector with the specified connection URL and collection name.
     *
     * @param connectionString The MongoDB connection string.
     * @param collectionName   The name of the MongoDB collection.
     */
    public MongoNewsConnector(String connectionString, String collectionName) {
        this.mongoDatabase = MongoClients.create(new ConnectionString(connectionString)).getDatabase(getDatabaseName(connectionString));
        this.collectionName = collectionName;
    }

    /**
     * Inserts a document into the MongoDB collection.
     *
     * @param document The document to be inserted.
     */
    public void insertDocument(Document document) {
        mongoDatabase.getCollection(collectionName).insertOne(document);
    }

    /**
     * Extracts the database name from the connection string.
     *
     * @param connectionString The MongoDB connection string.
     * @return The database name.
     */
    private String getDatabaseName(String connectionString) {
        return new ConnectionString(connectionString).getDatabase();
    }
}