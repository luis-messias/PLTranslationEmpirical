package com.example;
public class HumanEval_107 {
    public static void main(String[] args) {
        System.out.println(even_odd_palindrome(3));
        System.out.println(even_odd_palindrome(12));
    }

    public static String even_odd_palindrome(int n) {
        int oddCnt = 0, evenCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (String.valueOf(i).equals(new StringBuilder(String.valueOf(i)).reverse().toString())) {
                if (i % 2 == 1) {
                    oddCnt++;
                } else {
                    evenCnt++;
                }
            }
        }
        return "(" + evenCnt + ", " + oddCnt + ")";
    }
}