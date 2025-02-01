package com.dal.assignment2;

import org.apache.spark.sql.*;

import java.util.Arrays;
import java.util.List;

public class Problem1B {
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder()
                .appName("Word Frequency Counter")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> df = sparkSession.read().text("file:///home/iamtherockstar05/reut2-009.sgm");
        //df.write().csv("C:\\Himanshi\\spark\\df_old.csv");
        df = df.withColumn("value", functions.regexp_replace(functions.col("value"), "<[^>]+>|&lt;|[^a-zA-Z\\s]", " "));

        //df.write().csv("C:\\Himanshi\\spark\\df_transformed.csv");
        Dataset<String> words = df.selectExpr("explode(split(lower(value), ' ')) as word")
                .selectExpr("word")
                .as(Encoders.STRING())
                .filter("trim(word) != ''");

        List<String> stopWords = Arrays.asList(
                "a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if",
                "in", "into", "is", "it", "no", "not", "of", "on", "or", "such",
                "that", "the", "their", "then", "there", "these", "they", "this",
                "to", "was", "will", "with", "b", "c", "d", "e", "f", "s", "g", "h", "said"
        );

        // Filter out stop words
        words = words.filter(functions.expr("not word in ('" + String.join("','", stopWords) + "')"));

        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        wordAnalyzer.analyzeWords(words);

        sparkSession.stop();
    }
}