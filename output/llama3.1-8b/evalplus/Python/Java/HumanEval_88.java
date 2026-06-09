package com.example;
import java.util.Arrays;

public class HumanEval_88 {
    public static int[] sortArray(int[] array) {
        if (array.length == 0) return array;
        Arrays.sort(array);
        if ((array[0] + array[array.length - 1]) % 2 == 0) {
            reverseArray(array);
        }
        return array;
    }

    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {};
        int[] test2 = {5};
        int[] test3 = {2, 4, 3, 0, 1, 5};
        int[] test4 = {2, 4, 3, 0, 1, 5, 6};

        System.out.println(Arrays.toString(sortArray(test1)));
        System.out.println(Arrays.toString(sortArray(test2)));
        System.out.println(Arrays.toString(sortArray(test3)));
        System.out.println(Arrays.toString(sortArray(test4)));
    }
}