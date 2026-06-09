package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> oddCount(List<String> lst) {
        List<String> ans = new ArrayList<>();
        String template = "the number of odd elements in the string i of the input.";

        for (String s : lst) {
            int oddCnt = 0;
            for (char c : s.toCharArray()) {
                // Assuming input only contains digits
                int digit = Character.getNumericValue(c);
                if (digit % 2 != 0) {
                    oddCnt++;
                }
            }

            // Replace the placeholder 'i' with the calculated count
            String result = template.replace("i", String.valueOf(oddCnt));
            ans.add(result);
        }
        return ans;
    }
}