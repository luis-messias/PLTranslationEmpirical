package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_117 {

    public static List<String> selectWords(String s, int n) {
        List<String> ans = new ArrayList<>();
        
        String[] words = s.split(" ");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                char c;
                int consonantCount = 0;

                for (c = word.charAt(0); c != '\0'; c++) {
                    if ("aeiouAEIOU".indexOf(c) == -1 && Character.isLetter(c)) {
                        consonantCount++;
                    }
                }

                if (consonantCount == n) ans.add(word);
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(selectWords("Mary had a little lamb", 4)); // ==> [little]
        System.out.println(selectWords("Mary had a little lamb", 3)); // ==> [Mary, lamb]
        System.out.println(selectWords("simple white space", 2));   // ==> []
        System.out.println(selectWords("Hello world", 4));          // ==> [world]
        System.out.println(selectWords("Uncle sam", 3));            // ==> [Uncle]
    }
}