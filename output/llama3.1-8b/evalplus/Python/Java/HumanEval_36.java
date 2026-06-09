package com.example;
public class HumanEval_36 {
    public static int fizz_buzz(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                String strI = Integer.toString(i);
                count += strI.chars().filter(c -> c == '7').count();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(fizz_buzz(50)); // 0
        System.out.println(fizz_buzz(78)); // 2
        System.out.println(fizz_buzz(79)); // 3
    }
}