package com.example;

import java.util.ArrayList;
import java.util.List;

public class HumanEval_57 {

    public static boolean monotonic(List<Integer> list) {
        int prevElement = Integer.MIN_VALUE;

        for (int i : new ArrayList<>(list)) {
            if(i < prevElement){
                return false; // Decreasing sequence detected, not strictly increasing or decreasing.

            }

            if(prevElement > i && !isStrictlyIncreasing(list.subList(0,i+1))){

                return true; // Strictly Increasing until this point

            } else if (prevElement < i && !isStrictlyDecreasing(list.subList(i+1, list.size()))) {

                return false; // Decreasing sequence detected after a strictly increasing part.

            }

            prevElement = i;

        }

        boolean isIncreasing = true;
        for(int j : new ArrayList<>(list)){

            if(j < prevElement){

                continue;

            } else if (j > prevElement) {

                return false; // Non-increasing sequence detected after a strictly increasing part.

            }

            prevElement = j;

        }

        boolean isDecreasing = true;
        for(int k : new ArrayList<>(list)){

            if(k < prevElement){

                continue;

            } else if (k > prevElement) {

                return false; // Non-decreasing sequence detected after a strictly decreasing part.

            }

            prevElement = k;

        }

        return isIncreasing || isDecreasing;
    }


    private static boolean isStrictlyIncreasing(List<Integer> list) {
        for(int i=1;i<list.size();i++){
            if(list.get(i-1) >= list.get(i)){
                return false; // Not strictly increasing

            }
        }
        return true;

    }


    private static boolean isStrictlyDecreasing(List<Integer> list) {
        for(int i=1;i<list.size();i){
            if(list.get(i-1) <= list.get(i)){
                return false; // Not strictly decreasing
            }

        }
        return true;
    }

}
