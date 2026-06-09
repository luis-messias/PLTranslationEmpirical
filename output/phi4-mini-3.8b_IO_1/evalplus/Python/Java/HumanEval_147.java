package com.example;

public class HumanEval_147 {

    public static int getMaxTriples(int n) {
        if (n <= 2) return false;
        
        long oneCnt = 1 + ((n - 2) / 3 * 2L) + (n - 2 % 3);
        long zeroCnt = n - oneCnt;

        long resultOne = oneCnt * (oneCnt - 1L) / 6 % MODULO;
        long resultZero = zeroCnt * (zeroCnt - 1L) / 6 % MODULO;

        return ((int)(resultOne + resultZero)) % MODULO;
    }

}
