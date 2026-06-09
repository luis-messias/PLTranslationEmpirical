package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_1 {
    public static List<String> separateParenGroups(String parenString) {
        int cnt = 0, i = 0;
        String group = "";
        List<String> results = new ArrayList<>();
        
        for (char ch : parenString.toCharArray()) {
            if (ch == '(') cnt++;
            else if (ch == ')') cnt--;
            if (ch != ' ') group += ch;
            if (cnt == 0 && !group.isEmpty()) {
                results.add(group);
                group = "";
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        System.out.println(separateParenGroups("( ) (( )) (( )( ))"));
    }
}