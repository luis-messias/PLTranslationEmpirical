package com.example;
import java.util.ArrayList;
import java.util.Arrays;

public class HumanEval_101 {
    
    public static String[] wordsString(String s) {
        // Replace commas with spaces and split by space.
        String[] words = (s.replace(",", " ") + " ").split(" ");
        
        ArrayList<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {  // Check to avoid adding empty strings
                wordList.add(word);
            }
        }

        return wordList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wordsString("Hi, my name is John")));
        System.out.println(Arrays.toString(wordsString("One, two, three, four, five, six")));
    }
}