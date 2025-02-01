package com.dal.assignment2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class responsible for sentiment analysis of news titles.
 */
public class SentimentAnalyzer {
    private final PositiveNegativeWordLists lists;

    /**
     * Constructor for SentimentAnalyzer class.
     *
     * @throws IOException if an I/O error occurs.
     */
    public SentimentAnalyzer(String positiveWordsFile, String negativeWordsFile) throws IOException {
        this.lists = new PositiveNegativeWordLists(positiveWordsFile, negativeWordsFile);
    }

    public SentimentAnalysisResult analyzeSentiments(List<String> newsTitles) {
        System.out.println("Calculating scores .......");
        List<Integer> scores = newsTitles.stream()
                .map(this::createBagOfWords)
                .mapToInt(this::calculateScore)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Finding matches for all newsTitles....");
        List<String> matches = newsTitles.stream()
                .map(this::findMatches)
                .collect(Collectors.toList());
        System.out.println("Analysing polarities .......");
        List<String> polarities = scores.stream()
                .map(score -> score > 0 ? "Positive" : (score < 0 ? "Negative" : "Neutral"))
                .collect(Collectors.toList());

        return new SentimentAnalysisResult(scores, newsTitles, matches, polarities);
    }

    private Map<String, Integer> createBagOfWords(String title) {
        return Pattern.compile("\\b\\w+\\b")
                .matcher(title.toLowerCase())
                .results()
                .collect(Collectors.toMap(
                        match -> match.group(),
                        match -> 1,
                        Integer::sum));
    }

    private int calculateScore(Map<String, Integer> bagOfWords) {
        return bagOfWords.keySet().stream()
                .mapToInt(word -> lists.isPositive(word) ? 1 : lists.isNegative(word) ? -1 : 0)
                .sum();
    }

    private String findMatches(String title) {
        StringBuilder matchBuilder = new StringBuilder();
        Map<String, Integer> bagOfWords = createBagOfWords(title);
        for (String word : bagOfWords.keySet()) {
            if (lists.isPositive(word) || lists.isNegative(word)) {
                if (matchBuilder.length() > 0) {
                    matchBuilder.append(", ");
                }
                matchBuilder.append(word);
            }
        }
        return matchBuilder.toString();
    }
}
