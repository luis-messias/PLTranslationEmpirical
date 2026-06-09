package com.example;
import java.util.ArrayList;
import java.util.List;

public static List<String> wordsString(String s) {
    String[] words = s.replace(",", " ").split("\\s+");
    List<String> result = new ArrayList<>();
    for (String word : words) {
        if (!word.isEmpty()) {
            result.add(word);
        }
    }
    return result;
}