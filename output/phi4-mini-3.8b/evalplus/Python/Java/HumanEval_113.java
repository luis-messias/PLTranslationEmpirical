package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_113 {
    
    public static List<String> odd_count(List<String> lst) {
        List<String> ans = new ArrayList<>();
        String template = "the number of odd elements in the string i of the input.";
        
        for (String s : lst) {
            int oddCnt = 0;
            for (char ch : s.toCharArray()) {
                if ((ch - '0') % 2 == 1) {
                    oddCnt++;
                }
            }
            ans.add(template.replace("i", String.valueOf(oddCnt)));
        }
        
        return ans;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1234567");
        System.out.println(odd_count(input));
        
        input.clear();
        input.add("3");
        input.add("11111111");
        for (String str : odd_count(input)) {
            System.out.println(str);
        }
    }
}