package com.example;
import java.util.*;

public class HumanEval_158 {
    public static String findMax(List<String> words) {
        int mxChCnt = 0;
        String ans = "";
        
        for (String word : words) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            int chCnt = uniqueChars.size();
            
            if (chCnt > mxChCnt || (chCnt == mxChCnt && word.compareTo(ans) < 0)) {
                mxChCnt = chCnt;
                ans = word;
            }
        }
        
        return ans;
    }
}