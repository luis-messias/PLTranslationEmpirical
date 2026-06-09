package com.example;
public class HumanEval_100 {

    public static int[] make_a_pile(int n) {

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            if ((n + i) % 2 == 1) { // Odd index after adjusting to zero-based

                ans[i] = n - i;

            } else { // Even index after adjusting to zero-based

                ans[i] = (i ? ans[i-1] : n);

            }

        }

        return ans;

    }


    public static void main(String[] args) {

        int[] result = make_a_pile(3);

        for(int num: result){

            System.out.print(num + " ");

        }

    }

}