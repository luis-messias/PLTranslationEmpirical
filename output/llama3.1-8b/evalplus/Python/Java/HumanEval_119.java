package com.example;
public class HumanEval_119 {
    public static String matchParens(String[] lst) {
        return (validParens(lst[0] + lst[1]) || validParens(lst[1] + lst[0])) ? "Yes" : "No";
    }

    private static boolean validParens(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            cnt += (ch == '(') ? 1 : -1;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(matchParens(new String[]{"()(", ")"})); // Yes
        System.out.println(matchParens(new String[]{")", ")"})); // No
    }
}