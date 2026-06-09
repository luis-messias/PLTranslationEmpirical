package com.example;
import java.util.*;

public class HumanEval_158 {
    public static String findMax(String[] words) {
        int mxChCnt = 0;
        String ans = "";
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            int chCnt = set.size();
            if (chCnt > mxChCnt || (chCnt == mxChCnt && word.compareTo(ans) < 0)) {
                mxChCnt = chCnt;
                ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMax(new String[]{"name", "of", "string"})); // string
        System.out.println(findMax(new String[]{"name", "enam", "game"})); // enam
        System.out.println(findMax(new String[]{"aaaaaaa", "bb", "cc"})); // aaaaaaa
    }
}