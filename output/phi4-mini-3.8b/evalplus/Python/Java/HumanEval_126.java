package com.example;
public class HumanEval_126 {

    public static boolean isSorted(int[] list) {

        int[] counts = new int[101]; // Assuming no negative numbers and only integers up to 100

        for (int num : list) {
            if (++counts[num] > 2) return false;
        }

        java.util.Arrays.sort(list);

        for (int i = 0; i < list.length - 1; i++) {

            if (list[i] > list[i + 1]) return false;

        }

        return true;

    }


    public static void main(String[] args) {

        int[] testList = {5};

        System.out.println(isSorted(testList)); // ➞ True

    }

}