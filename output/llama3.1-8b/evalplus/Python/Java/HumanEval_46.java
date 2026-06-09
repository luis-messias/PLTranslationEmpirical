package com.example;
public class HumanEval_46 {
    public static int fib4(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 0;
        } else {
            int a = 0, b = 0, c = 2, d = 0;
            for (int i = 4; i <= n; i++) {
                a = b; 
                b = c; 
                c = d; 
                d = a + b + c + d;
            }
            return d;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib4(5));
        System.out.println(fib4(6));
        System.out.println(fib4(7));
    }
}