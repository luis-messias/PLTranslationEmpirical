package com.example;
import java.util.Arrays;

public class HumanEval_105 {
    public static String[] byLength(int[] arr) {
        String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        Arrays.sort(arr);
        int[] sortedList = new int[arr.length];
        System.arraycopy(arr, 0, sortedList, 0, arr.length);
        for (int i = 0; i < sortedList.length / 2; i++) {
            int temp = sortedList[i];
            sortedList[i] = sortedList[sortedList.length - i - 1];
            sortedList[sortedList.length - i - 1] = temp;
        }
        String[] ans = new String[arr.length];
        for (int x : sortedList) {
            if (x >= 1 && x <= 9) {
                int index = x - 1;
                ans[index] = words[index];
            }
        }
        return Arrays.copyOf(ans, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 4, 5, 8, 2, 3};
        System.out.println(Arrays.toString(byLength(arr)));
    }
}
