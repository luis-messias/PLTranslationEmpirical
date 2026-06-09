package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < lst.size(); i++) {
            List<Integer> l = lst.get(i);
            // Iterate columns j in reverse order (descending)
            for (int j = l.size() - 1; j >= 0; j--)