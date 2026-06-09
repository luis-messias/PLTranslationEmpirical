package com.example;
public class HumanEval_155 {
    public static int[] evenOddCount(int num) {
        int even = 0;
        int odd = 0;
        String strNum = Integer.toString(Math.abs(num));
        for (char ch : strNum.toCharArray()) {
            if ("02468".indexOf(ch) != -1) even++;
            else if ("13579".indexOf(ch) != -1) odd++;
        }
        return new int[] {even, odd};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(evenOddCount(-12)));
        System.out.println(java.util.Arrays.toString(evenOddCount(123)));
    }
}