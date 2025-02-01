import com.dal.assignment2.SentimentAnalysisResult;
import com.dal.assignment2.SentimentAnalyzer;

import java.io.IOException;
import java.util.List;

public class Problem3Test {

    public static void main(String[] args) {
        testPositiveSentiment();
        testNegativeSentiment();
        testNeutralSentiment();
    }

    public static void testPositiveSentiment() {
        try {
            SentimentAnalyzer analyzer = new SentimentAnalyzer("positive_words.txt", "negative_words.txt");
            List<String> newsTitles = List.of("Exciting news: Company XYZ announces record profits!");
            SentimentAnalysisResult result = analyzer.analyzeSentiments(newsTitles);
            System.out.println("Sentiment: " + result.getPolarities().get(0)); // Expected: Positive
            if(result.getPolarities().get(0).equals("Positive")){
                System.out.println("Test Passed");
            }
            else{
                System.out.println("Test Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testNegativeSentiment() {
        try {
            SentimentAnalyzer analyzer = new SentimentAnalyzer("positive_words.txt", "negative_words.txt");
            List<String> newsTitles = List.of("Disappointing news: Company ABC reports losses in the latest quarter.");
            SentimentAnalysisResult result = analyzer.analyzeSentiments(newsTitles);
            System.out.println("Sentiment: " + result.getPolarities().get(0)); // Expected: Negative
            if(result.getPolarities().get(0).equals("Negative")){
                System.out.println("Test Passed");
            }
            else{
                System.out.println("Test Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testNeutralSentiment() {
        try {
            SentimentAnalyzer analyzer = new SentimentAnalyzer("positive_words.txt", "negative_words.txt");
            List<String> newsTitles = List.of("Company ABC announces new product launch.");
            SentimentAnalysisResult result = analyzer.analyzeSentiments(newsTitles);
            System.out.println("Sentiment: " + result.getPolarities().get(0)); // Expected: Neutral
            if(result.getPolarities().get(0).equals("Neutral")){
                System.out.println("Test Passed");
            }
            else{
                System.out.println("Test Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
