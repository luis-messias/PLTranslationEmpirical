package com.example;
public class HumanEval_83 {

    public static int startsOneEnds(int n) {
        if(n == 1) return 1;

        double result = 18 * Math.pow(10, (n - 2));
        return (int)result; // Cast to integer

    }

}
