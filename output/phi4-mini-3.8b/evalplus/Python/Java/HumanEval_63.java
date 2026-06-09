package com.example;
public class HumanEval_63 {

    public static int fibfib(int n) {

        if (n == 0 || n == 1) {
            return 0;

        } else if (n == 2) {

            return 1;

        }

        long a = 0, b = 0, c = 1;

        for (int i = 3; i <= n; i++) {

            int tempA = a + b + c;
            System.arraycopy(new int[]{a, b}, 0, new int[] {b, c});

            a = b;

            b = c;

            c = tempA;

        }

        return (int) c;

    }


    public static void main(String[] args) {

        System.out.println(fibfib(1)); // Output: 0

        System.out.println(fibfib(5)); // Output: 4

        System.out.println(fibfib(8)); // Output: 24

    }

}