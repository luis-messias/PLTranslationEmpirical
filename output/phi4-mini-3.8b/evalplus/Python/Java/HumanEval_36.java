package com.example;
public class HumanEval_36 {

    public static int fizz_buzz(int n) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if ((i % 11 == 0 || i % 13 == 0)) {

                // Convert the number to a string and filter out '7's

                int countOfSeven = Integer.toString(i).chars().filter(ch -> ch == '7').count();

                result.append(countOfSeven);

            }

        }

        return Character.getNumericValue(result.charAt(0));

    }


    public static void main(String[] args) {

        System.out.println(fizz_buzz(50)); // Output: 0

        System.out.println(fizz_buzz(78)); // Output: 2

        System.out.println(fizz_buzz(79)); // Output: 3

    }

}