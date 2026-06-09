package com.example;
public class HumanEval_61 {
    public static boolean correctBracketing(String brackets) {
        int cnt = 0;
        for (char x : brackets.toCharArray()) {
            if (x == '(') cnt++;
            else if (x == ')') cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(correctBracketing("(")); // False
        System.out.println(correctBracketing("()")); // True
        System.out.println(correctBracketing("(()())")); // True
        System.out.println(correctBracketing(")((")); // False
    }
}