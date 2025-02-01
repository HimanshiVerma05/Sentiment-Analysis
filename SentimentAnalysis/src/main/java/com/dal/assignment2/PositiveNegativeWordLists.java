package com.dal.assignment2;

import java.io.IOException;
import java.util.List;

/**
 * Class representing positive and negative word lists.
 */
public class PositiveNegativeWordLists {
    private final List<String> positiveWords;
    private final List<String> negativeWords;

    /**
     * Constructor for PositiveNegativeWordLists class.
     *
     * @param positiveWordsFile Path to file containing positive words.
     * @param negativeWordsFile Path to file containing negative words.
     * @throws IOException if an I/O error occurs.
     */
    public PositiveNegativeWordLists(String positiveWordsFile, String negativeWordsFile) throws IOException {
        this.positiveWords = FileHelper.readLines(positiveWordsFile);
        this.negativeWords = FileHelper.readLines(negativeWordsFile);
    }

    /**
     * Checks if a word is positive.
     *
     * @param word The word to check.
     * @return true if the word is positive, otherwise false.
     */
    public boolean isPositive(String word) {
        return positiveWords.contains(word);
    }

    /**
     * Checks if a word is negative.
     *
     * @param word The word to check.
     * @return true if the word is negative, otherwise false.
     */
    public boolean isNegative(String word) {
        return negativeWords.contains(word);
    }
}

