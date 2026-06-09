package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {

    public List<String> odd_count(List<String> lst) {
        List<String> ans = new ArrayList<>();
        String template = "the number of odd elements in the string i of the input.";

        for (String s : lst) {
            int oddCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                // Check if the character is a digit
                if (Character.isDigit(ch)) {
                    // Convert char digit to int
                    int digit = ch - '0';
                    // Check if the digit is odd
                    if (digit % 2 != 0) {
                        oddCnt++;
                    }
                }
            }
            
            // Replace all occurrences of "i" with the calculated odd count
            String result = template.replace("i", String.valueOf(oddCnt));
            ans.add(result);
        }
        return ans;
    }
}