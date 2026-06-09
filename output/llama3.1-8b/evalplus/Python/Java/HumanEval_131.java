package com.example;
public class HumanEval_131 {
    public static int digits(int n) {
        boolean hasOdd = false;
        int product = 1;
        String strN = Integer.toString(n);
        for (char c : strN.toCharArray()) {
            if ((c - '0') % 2 == 1) {
                hasOdd = true;
                product *= (c - '0');
            }
        }
        return hasOdd ? product : 0;
    }

    public static void main(String[] args) {
        System.out.println(digits(1));   // prints: 1
        System.out.println(digits(4));   // prints: 0
        System.out.println(digits(235)); // prints: 15
    }
}