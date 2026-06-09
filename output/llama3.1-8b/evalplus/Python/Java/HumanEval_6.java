package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {
    public static List<Integer> parseNestedParens(String parenString) {
        return new ArrayList<>(java.util.Arrays.stream(parenString.split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(Main::countDepth)
                .toList());
    }

    private static int countDepth(String s) {
        int maxDepth = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') cnt++;
            if (ch == ')') cnt--;
            maxDepth = Math.max(maxDepth, cnt);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        System.out.println(parseNestedParens("(()()) ((())) () ((())()())"));
    }
}