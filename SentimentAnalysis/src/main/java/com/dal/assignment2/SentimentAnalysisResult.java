package com.dal.assignment2;

import java.util.List;

/**
 * Class representing the result of sentiment analysis.
 */
public class SentimentAnalysisResult {
    private final List<String> matches;
    private final List<Integer> scores;
    private final List<String> polarities;
    private final List<String> newsTitles;


    public SentimentAnalysisResult(List<Integer> scores, List<String> titles, List<String> matches, List<String> polarities) {
        this.scores = scores;
        this.newsTitles = titles;
        this.matches = matches;
        this.polarities = polarities;
    }

    /**
     * Gets the list of match words for each news title.
     *
     * @return List of match words.
     */
    public List<String> getMatches() {
        return matches;
    }

    /**
     * Gets the list of scores for each news title.
     *
     * @return List of scores.
     */
    public List<Integer> getScores() {
        return scores;
    }

    /**
     * Gets the list of polarities for each news title.
     *
     * @return List of polarities.
     */
    public List<String> getPolarities() {
        return polarities;
    }

    /**
     * Gets the list of news titles.
     *
     * @return List of news titles.
     */
    public List<String> getNewsTitles() {
        return newsTitles;
    }
}