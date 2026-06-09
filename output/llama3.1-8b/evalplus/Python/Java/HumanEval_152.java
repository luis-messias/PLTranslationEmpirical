package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_152 {
    public static List<Integer> compare(List<Integer> game, List<Integer> guess) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < game.size(); i++) {
            result.add(Math.abs(game.get(i) - guess.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        // example usage:
        List<Integer> game1 = new ArrayList<>(List.of(1,2,3,4,5,1));
        List<Integer> guess1 = new ArrayList<>(List.of(1,2,3,4,2,-2));
        System.out.println(compare(game1, guess1)); // [0, 0, 0, 0, 3, 3]

        List<Integer> game2 = new ArrayList<>(List.of(0,5,0,0,0,4));
        List<Integer> guess2 = new ArrayList<>(List.of(4,1,1,0,0,-2));
        System.out.println(compare(game2, guess2)); // [4, 4, 1, 0, 0, 6]
    }
}