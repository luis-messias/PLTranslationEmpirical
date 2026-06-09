package com.example;
import java.util.Arrays;

public class HumanEval_70 {
    public static int[] strangeSortList(int[] lst) {
        if (lst.length == 0) return new int[0];
        
        Arrays.sort(lst);
        int[] ans = new int[lst.length];
        int i = 0, j = lst.length - 1;
        while (i < j) {
            ans[i] = lst[i];
            ans[j] = lst[j];
            i++;
            j--;
        }
        if (i == j) ans[i] = lst[i];
        
        return ans;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(strangeSortList(test1)));
        
        int[] test2 = {5, 5, 5, 5};
        System.out.println(Arrays.toString(strangeSortList(test2)));
        
        int[] test3 = {};
        System.out.println(Arrays.toString(strangeSortList(test3)));
    }
}