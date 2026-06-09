package com.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HumanEval_34 {

    public static void main(String[] args) {
        int[] input = {5, 3, 5, 2, 3, 3, 9, 0, 123};
        System.out.println(Arrays.toString(unique(input)));
    }

    public static Integer[] unique(int[] l) {
        Set<Integer> set = new HashSet<>();
        for (int num : l) {
            set.add(num);
        }
        
        int index = 0;
        Integer[] result = new Integer[set.size()];
        for (Integer number : set) {
            result[index++] = number;
        }

        return Arrays.sort(result); // Sort the array before returning
    }
}