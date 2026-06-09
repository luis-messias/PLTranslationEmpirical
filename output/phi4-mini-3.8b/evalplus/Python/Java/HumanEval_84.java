package com.example;
public class HumanEval_84 {

    public static String solve(int N) {
        // Given a positive integer N, returns total sum of its digits in binary.
        
        int s = 0;
        while (N > 0) {
            s += N % 10; // Sum the last digit and remove it
            N /= 10;     // Remove this digit from consideration
        }
        
        return Integer.toBinaryString(s); // Convert sum to binary string representation without '0b' prefix.
    }

    public static void main(String[] args) {
        System.out.println(solve(1000));   // Output should be "11"
        System.out.println(solve(150));    // Output should be "110"
        System.out.println(solve(147));    // Output should be "11000"
    }
}