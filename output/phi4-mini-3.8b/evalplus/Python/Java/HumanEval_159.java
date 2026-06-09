package com.example;
public class HumanEval_159 {

    public static int[] eat(int number, int need, int remaining) {
        if (need <= remaining) {
            return new int[]{number + need, remaining - need};
        } else {
            return new int[]{number + remaining, 0};
        }
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(Arrays.toString(eat(5, 6, 10))); // Output: [11, 4]
        System.out.println(Arrays.toString(eat(4, 8, 9)));   // Output: [12, 1]
        System.out.println(Arrays.toString(eat(1, 10, 10)));  // Output: [11, 0]
        System.out.println(Arrays.toString(eat(2, 11, 5)));    // Output: [7, 0]
    }
}