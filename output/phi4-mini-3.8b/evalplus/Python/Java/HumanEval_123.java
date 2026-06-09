package com.example;
import java.util.ArrayList;

import java.util.Collections;


public class HumanEval_123 {

    public static ArrayList<Integer> getOddCollatz(int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        int x = n;

        while (x != 1) {

            if (x % 2 == 1) ans.add(x);

            x = (x % 2 == 0) ? x / 2 : x * 3 + 1;

        }

        ans.add(1);

        Collections.sort(ans);

        return ans;

    }


}