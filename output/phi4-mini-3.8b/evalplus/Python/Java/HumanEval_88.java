package com.example;
import java.util.Arrays;

public class HumanEval_88 {

    public static int[] sort_array(int[] array) {
        if (array.length == 0) return new int[]{};
        
        Arrays.sort(array);
        
        boolean isEvenSum = ((array[0] + array[array.length - 1]) % 2 == 0);

        if(isEvenSum){
            reverseArray(array, 0, array.length-1); 
        }
        
        return array;
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while(start < end) {    
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        } 
    }
}