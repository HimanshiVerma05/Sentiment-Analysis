import com.dal.assignment2.NewsArticle;
import com.dal.assignment2.ReuterArticleParser;
import com.dal.assignment2.TextCleaner;

import java.util.List;

/**
 * Class for testing the functionality of parsing articles and cleaning text.
 */
class Problem1ATest {

    /**
     * Main method to run the test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Problem1ATest tests = new Problem1ATest();
        tests.testParsingArticles();
        tests.testCleaningText();
        tests.testSpecialCharactersRemoval();
    }

    /**
     * Test case to verify the parsing of articles.
     */
    public void testParsingArticles() {
        String fileContent = "<REUTERS><TITLE>Test Title</TITLE><BODY>Test Body</BODY></REUTERS>";
        ReuterArticleParser articleParser = new ReuterArticleParser();
        List<NewsArticle> articles = articleParser.parseArticles(fileContent);

        if (articles.size() == 1) {
            System.out.println("Parsing articles test passed");
        } else {
            System.out.println("Parsing articles test failed");
        }
    }

    /**
     * Test case to verify the cleaning of text.
     */
    public void testCleaningText() {
        TextCleaner textCleaner = new TextCleaner();
        String dirtyText = "This is a &lt;test> text!";
        String cleanText = textCleaner.cleanText(dirtyText);

        if (cleanText.equals("This is a test text")) {
            System.out.println("Cleaning text test passed");
        } else {
            System.out.println("Cleaning text test failed");
        }
    }

    /**
     * Test case to verify the removal of special characters.
     */
    public void testSpecialCharactersRemoval() {
        TextCleaner textCleaner = new TextCleaner();
        String dirtyText = "This is a &lt;test> text!";
        String cleanedText = textCleaner.cleanText(dirtyText);

        if (!cleanedText.contains("&lt;") && !cleanedText.contains(">")) {
            System.out.println("Special characters removal test passed");
        } else {
            System.out.println("Special characters removal test failed");
        }
    }

}
