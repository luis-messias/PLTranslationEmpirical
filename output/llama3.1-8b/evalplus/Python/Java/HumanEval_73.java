package com.example;
public class HumanEval_73 {
    public static int smallestChange(int[] arr) {
        int[] arrReversed = new int[arr.length];
        System.arraycopy(arr, 0, arrReversed, 0, arr.length);
        reverseArray(arrReversed);

        int cnt = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arrReversed[i]) {
                cnt++;
            }
        }
        return cnt;
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
        // Test cases
        int[] arr1 = {1, 2, 3, 5, 4, 7, 9, 6};
        System.out.println(smallestChange(arr1)); // Output: 4

        int[] arr2 = {1, 2, 3, 4, 3, 2, 2};
        System.out.println(smallestChange(arr2)); // Output: 1

        int[] arr3 = {1, 2, 3, 2, 1};
        System.out.println(smallestChange(arr3)); // Output: 0
    }
}