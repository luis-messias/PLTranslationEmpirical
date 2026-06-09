package com.example;
public class HumanEval_121 {

    public static int solution(int[] lst) {

        int sum = 0;

        for (int i = 0; i < lst.length; i += 2) {

            if ((lst[i] % 2 == 1)) { // Check if the element is odd

                sum += lst[i];

            }

        }

        return sum;

    }


    public static void main(String[] args) {

        int result = solution(new int[]{5, 8, 7, 1});

        System.out.println(result); // Output: 12


        result = solution(new int[]{3, 3, 3, 3, 3});

        System.out.println(result); // Output: 9

    }

}