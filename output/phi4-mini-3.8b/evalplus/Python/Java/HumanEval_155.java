package com.example;
public class HumanEval_155 {

    public static int[] countEvenAndOddDigits(int num) {

        String strNum = Integer.toString(Math.abs(num));

        int evenCount = 0;

        for (char ch : strNum.toCharArray()) {

            if ("02468".indexOf(ch) != -1) { // Check if the character is an even digit

                evenCount++;

            } else if ("13579".indexOf(ch) != -1) { // Check if it's not a valid odd digit (to avoid confusion with negative numbers)

                continue;

            }

        }

        int[] result = new int[2];

        result[0] = evenCount; // Even digits count

        result[1] = strNum.length() - evenCount; // Odd digits count by subtracting the number of evens from total length

        return result;

    }


    public static void main(String[] args) {

        int[] counts = countEvenAndOddDigits(-12);

        System.out.println("Even: " + counts[0] + ", Odd: " + counts[1]);

    }

}