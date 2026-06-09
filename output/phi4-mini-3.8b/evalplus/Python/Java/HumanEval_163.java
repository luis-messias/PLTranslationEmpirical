package com.example;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_163 {

    public static void main(String[] args) {
        System.out.println(generateIntegers(2, 8)); // Example usage
    }

    /**
     * Given two positive integers a and b, return the even digits between a
     * and b (inclusive), in ascending order.
     *
     * @param a The starting integer of range to check for even numbers. Must be non-negative.
     * @param b  The ending integer of range to check for even numbers. Must not exceed 'a'.
     * @return An ArrayList containing the sorted, unique integers between [min(a,b), max(a,b)] that are divisible by two (even).
     */
    public static int[] generateIntegers(int a, int b) {
        if (b > a) { // Swap values to ensure ascending order
            int temp = a;
            a = b;
            b = temp;
        }

        ArrayList<Integer> evenDigits = new ArrayList<>();
        
        for (int i = Math.max(a, 0); i <= Math.min(b + 1, 10) - 1; ++i) {
            if(i % 2 == 0){
                evenDigits.add(i);
            }
        }

        Collections.sort(evenDigits);

        int[] resultArray = new int[evenDigits.size()];
        
        for (int i = 0; i < evenDigits.size(); i++) {
            resultArray[i] = evenDigits.get(i);
        }
        
        return resultArray;
    }
}