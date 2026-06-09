package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_33 {
    public List<Integer> sortThird(List<Integer> l) {
        int n = l.size();
        
        // 1. Extract elements at indices divisible by 3
        List<Integer> third = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                third.add(l.get(i));
            }
        }
        
        // 2. Sort these extracted elements
        Collections.sort(third);
        
        // 3. Construct the result list
        List<Integer> result = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                // If index i is divisible by 3, use the sorted 'third' elements.
                // The index into 'third' is i / 3.
                int k = i / 3;
                result.add(third.get(k));