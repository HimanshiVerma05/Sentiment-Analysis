package com.dal.assignment2;

/**
 * Class responsible for removing special characters from text
 */
public class TextCleaner {

    public String cleanText(String text) {

        String specialCharactersRegex = "[^a-zA-Z0-9\\s]";
        return text == null ? "" : text.replaceAll("&lt;", "")
                .replaceAll(">", "")
                .replaceAll(specialCharactersRegex, "");
    }
}

