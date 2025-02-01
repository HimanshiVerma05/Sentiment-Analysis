package com.dal.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class responsible for parsing Reuters articles from the file content.
 */
public class ReuterArticleParser {

    public List<NewsArticle> parseArticles(String fileContent) {
        List<NewsArticle> articles = new ArrayList<>();
        Pattern pattern = Pattern.compile("<REUTERS.*?</REUTERS>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fileContent);

        while (matcher.find()) {
            String reuter = matcher.group();
            String title = extractText(reuter, "<TITLE>", "</TITLE>");
            String body = extractText(reuter, "<BODY>", "</BODY>");

            articles.add(new NewsArticle(title, body));

        }

        return articles;
    }

    private String extractText(String input, String startTag, String endTag) {
        Pattern pattern = Pattern.compile(startTag + "(.*?)" + endTag, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            return "";
        }
    }

}