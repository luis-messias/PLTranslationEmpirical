package com.example;
public class HumanEval_100 {

    public static int[] make_a_pile(int n) {
        if (n <= 0) throw new IllegalArgumentException("Input must be a positive integer");

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 1) { // Odd index after adjusting to zero-based
                ans[i] = n - i;
            } else { // Even index after adjusting to zero-based
                ans[i] = (ans.length > i ? ans[i-1] : n);
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
