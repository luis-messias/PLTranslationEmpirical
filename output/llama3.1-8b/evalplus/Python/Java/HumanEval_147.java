package com.example;
public class HumanEval_147 {
    public static int get_max_triples(int n) {
        if (n <= 2) return 0;
        int oneCnt = 1 + (n - 2) / 3 * 2 + (n - 2) % 3;
        int zeroCnt = n - oneCnt;
        return (int)((oneCnt * (long)(oneCnt - 1) * (oneCnt - 2)) / 6 +
                (zeroCnt * (long)(zeroCnt - 1) * (zeroCnt - 2)) / 6);
    }

    public static void main(String[] args) {
        System.out.println(get_max_triples(5));
    }
}