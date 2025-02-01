package com.dal.assignment2;

import org.bson.Document;

/**
 * Class representing a news article.
 */
public class NewsArticle {
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Constructs a new NewsArticle with the specified title and body.
     *
     * @param title The title of the news article.
     * @param body  The body of the news article.
     */
    public NewsArticle(String title, String body) {
        this.title = title;
        this.body = body;
    }

    /**
     * Converts the NewsArticle object to a MongoDB Document.
     *
     * @return The NewsArticle object as a MongoDB Document.
     */
    public Document toDocument() {
        return new Document("title", title)
                .append("body", body);
    }
}
