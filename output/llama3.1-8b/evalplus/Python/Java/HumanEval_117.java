package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HumanEval_117 {
    public static List<String> selectWords(String s, int n) {
        List<String> ans = new ArrayList<>();
        String[] words = s.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                int cCnt = word.replaceAll("[aeiouAEIOU]", "").length();
                if (cCnt == n) {
                    ans.add(word);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(selectWords("Mary had a little lamb", 4));
        System.out.println(selectWords("Mary had a little lamb", 3));
        System.out.println(selectWords("simple white space", 2));
        System.out.println(selectWords("Hello world", 4));
        System.out.println(selectWords("Uncle sam", 3));
    }
}