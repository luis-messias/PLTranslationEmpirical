package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_117 {
    public static List<String> selectWords(String s, int n) {
        List<String> ans = new ArrayList<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                int c_cnt = 0;
                for (char ch : word.toCharArray()) {
                    if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && 
                        ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I' && 
                        ch != 'O' && ch != 'U') {
                        c_cnt++;
                    }
                }
                if (c_cnt == n) {
                    ans.add(word);
                }
            }
        }
        return ans;
    }
}