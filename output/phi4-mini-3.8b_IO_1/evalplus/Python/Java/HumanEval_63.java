package com.example;
public class HumanEval_63 {

    public static int fibfib(int n) {
        if (n == 0 || n == 1) return 0;

        long a = 0L, b = 0L, c = 1L;

        for (int i = 2; i <= n; i++) {
            int tempA = (int)(a + b + c);
            System.arraycopy(new int[]{(int)a, (int)b}, 0, new int[] {(int)b, (int)c});

            a = (long) b;
            b = (long) c;
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
