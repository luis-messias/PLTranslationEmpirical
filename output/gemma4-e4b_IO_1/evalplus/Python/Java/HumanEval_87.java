package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // Helper class to represent the coordinate pair (row, col)
    static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // Optional: Override toString for easy testing/debugging
        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    /**
     * Finds all coordinates (row, col) where the value x appears in the ragged matrix lst.
     * The results are sorted by row ascending, and then by column descending.
     * 
     * @param lst The 2D list (ragged matrix) of integers.
     * @param x The target integer.
     * @return A list of Coordinate objects representing the found locations.
     */
    public List<Coordinate> getRow(List<List<Integer>> lst, int x) {
        List<Coordinate> res = new ArrayList<>();

        // Iterate through rows (i)
        for (int i = 0; i < lst.size(); i++) {
            List<Integer> l = lst.get(i);
            
            // Iterate through columns (j) in descending order
            for (int j = l.size() - 1; j >= 0; j--) {
                if (l.get(j) == x) {
                    res.add(new Coordinate(i, j));
                }
            }
        }
        return res;
    }
}
