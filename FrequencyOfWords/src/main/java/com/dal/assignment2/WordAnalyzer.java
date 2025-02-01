package com.dal.assignment2;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;

public class WordAnalyzer {
    public void analyzeWords(Dataset<String> words) {
        Dataset<Row> wordCounts = words.groupBy("word").count();

        Dataset<Row> maxFrequencyWords = wordCounts.groupBy().agg(functions.max("count").alias("max_count"))
                .join(wordCounts, wordCounts.col("count").equalTo(functions.col("max_count")))
                .select("word", "max_count");

        System.out.println("Word(s) with maximum frequency:");
        maxFrequencyWords.show();

        Dataset<Row> minFrequencyWords = wordCounts.groupBy().agg(functions.min("count").alias("min_count"))
                .join(wordCounts, wordCounts.col("count").equalTo(functions.col("min_count")))
                .select("word", "min_count");

        System.out.println("Word(s) with minimum frequency:");
        minFrequencyWords.show();

    }
}
