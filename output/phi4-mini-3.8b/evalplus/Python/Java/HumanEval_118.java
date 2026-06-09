package com.example;
public class HumanEval_118 {
    
    public static String getClosestVowel(String word) {
        for (int i = word.length() - 2; i > 0; --i) {
            char ch = word.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) != -1 && 
                "aeiouAEIOU".indexOf(word.charAt(i-1)) == -1 &&
                "aeiouAEIOU".indexOf(word.charAt(i+1)) == -1) {
                return String.valueOf(ch);
            }
        }
        return "";
    }

}