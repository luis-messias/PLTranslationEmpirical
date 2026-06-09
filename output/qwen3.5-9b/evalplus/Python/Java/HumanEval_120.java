package com.example;
import java.util.*;

public class HumanEval_120 {
    public List<Integer> maximum(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        
        Collections.sort(list);
        
        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            result.add(list.get(i));
        }
        
        Collections.sort(result);
        
        return result;
    }
}