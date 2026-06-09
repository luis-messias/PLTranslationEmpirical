package com.example;
import java.util.*;

public class HumanEval_113 {
    public static List<String> oddCount(List<String> lst) {
        List<String> ans = new ArrayList<>();
        String template = "the number of odd elements in the string i of the input.";
        for (String s : lst) {
            int oddCnt = 0;
            for (char ch : s.toCharArray()) {
                if ((ch - '0') % 2 == 1) {
                    oddCnt++;
                }
            }
            String temp = template.replace("i", String.valueOf(oddCnt));
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("1234567");
        System.out.println(oddCount(lst));

        lst = Arrays.asList("3", "11111111");
        System.out.println(oddCount(lst));
    }
}