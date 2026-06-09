package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanEval_145 {

    public static void main(String[] args) {
        int[] nums = {1, 11, -1, -11, -12};
        Integer[] sortedNums = orderByPoints(nums);
        
        System.out.println(Arrays.toString(sortedNums));
    }

    private static Integer[] orderByPoints(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int weight = calculateWeight(num);
            list.add(weight); // Add only the weights
        }
        
        Collections.sort(list, Comparator.comparingInt(Integer::toString));
        
        Integer[] resultArray = new Integer[list.size()];
        System.arraycopy(list.toArray(new Integer[0]), 0, resultArray, 0, list.size());
        
        return resultArray;
    }

    private static int calculateWeight(int x) {
        String str = Math.abs(x).toString();
        boolean isNegative = (x < 0);
        if(isNegative){
            str = "-" + str.substring(1); // Remove negative sign for processing
        }
        
        ArrayList<Integer> digits = new ArrayList<>();
        int index;
        while ((index = str.indexOf(nextSpace(str, -1), true)) != -1) {
            String digitStr = str.substring(index);
            if (digitStr.length() > 0){
                digits.add(Integer.parseInt(digitStr));
            }
            str = str.substring(0, index + nextSpaceLength(str, -1)); // Move past the space
        }

        int sum;
        try {
            for(int digit : digits) {
                sum += Math.abs(digit);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid number format", e);
        }
        
        if(isNegative)
            return -sum; // Return negative weight
        else 
            return sum;
    }

    private static int nextSpace(String str, int index) {
        while(index < str.length() && Character.isWhitespace(str.charAt(index))) {
            index++;
        }
        return index;
    }

    private static int nextSpaceLength(String str, int index){
        if (index >= str.length()) { // No more spaces
            return 0;
        } else if (!Character.isWhitespace(str.charAt(index))){
            return -1; // Not a space character at this position.
        }
        
        while (index < str.length() && Character.isWhitespace(str.charAt(index))) {
            index++;
        }

        int nextSpaceIndex = index;

        for (;nextSpaceIndex < str.length(); nextSpaceIndex++) {
            if (!Character.isWhitespace(str.charAt(nextSpaceIndex))){
                break;
            }
        }

        return (index - nextSpaceIndex);
    }
}
