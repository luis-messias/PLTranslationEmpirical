package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_104 {

    public static void main(String[] args) {
        List<Integer> result1 = unique_digits(new int[]{15, 33, 1422, 1});
        System.out.println(result1); // Output: [1, 15, 33]

        List<Integer> result2 = unique_digits(new int[]{152, 323, 1422, 10});
        System.out.println(result2); // Output: []
    }

    public static List<Integer> uniqueDigits(int[] x) {
        return filter(x);
    }

    private static boolean judge(int num) {
        String strNum = Integer.toString(num);
        for (char ch : strNum.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> filter(int[] x) {
        ArrayList<Integer> filteredNumbers = new ArrayList<>();
        for (int num : x) {
            if (judge(num)) {
                filteredNumbers.add(num);
            }
        }
        Collections.sort(filteredNumbers);
        return filteredNumbers;
    }
}