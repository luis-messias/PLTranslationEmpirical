package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> compare(List<Integer> game, List<Integer> guess) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < game.size(); i++) {
            int difference = Math.abs(game.get(i) - guess.get(i));
            result.add(difference);
        }
        return result;
    }
}