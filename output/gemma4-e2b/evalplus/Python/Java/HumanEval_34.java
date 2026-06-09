package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> uniqueSet = new HashSet<>(l);
        List<Integer> result = new ArrayList<>(uniqueSet);
        Collections.sort(result);
        return result;
    }
}