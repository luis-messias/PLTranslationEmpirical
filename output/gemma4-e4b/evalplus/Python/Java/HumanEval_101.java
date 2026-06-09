package com.example;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * You will be given a string of words separated by commas or spaces. Your task is
     * to split the string into words and return an array of the words.
     *
     * For example:
     * words_string("Hi, my name is John") == ["Hi", "my", "name", "is", "John"]
     * words_string("One, two, three, four, five, six") == ["One", "two", "three", "four", "five", "six"]
     */
    public String[] wordsString(String s) {
        // Replace commas with spaces, then split by one or more whitespace characters.
        // The regex "\\s+" handles multiple spaces resulting from the replacement or original string.
        String[] words = s.replace(",", " ").trim().split("\\s+");

        // Handle the case where the input string might be empty or only contain separators
        if (words.length == 1 && words[0].isEmpty()) {
            return new String[0];
        }
        
        return words;
    }
}