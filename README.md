# Reuters Sentiment Analysis

## **Overview**
This project is a **Sentiment Analysis** system for Reuters news articles using a **Bag-of-Words (BOW) model**. The solution is implemented in **Java (Core Java, No additional libraries)** and stores news data in **MongoDB**. The analysis determines the sentiment (Positive, Negative, Neutral) of news titles.

## **Implementation Details**
### **Algorithm**
1. **Connect to MongoDB**: Retrieve news titles stored in `ReutersDB`.
2. **Create Bag-of-Words (BOW) Representation**:
   - Extract individual words from each title.
   - Count occurrences of each word.
3. **Sentiment Analysis**:
   - Compare words in titles with lists of **positive** and **negative** words.
   - Assign scores: 
     - `+1` for positive words
     - `-1` for negative words
   - Compute the **overall sentiment score** for each title.
4. **Determine Sentiment**:
   - Positive Score → **Positive**
   - Negative Score → **Negative**
   - Score of `0` → **Neutral**
5. **Store Results**:
   - Save sentiment analysis results in a **CSV file (`news_sentiment_analysis.csv`)**.

## **Execution Instructions**
### **Prerequisites**
- **Java 11+**
- **MongoDB**
- **Git**


