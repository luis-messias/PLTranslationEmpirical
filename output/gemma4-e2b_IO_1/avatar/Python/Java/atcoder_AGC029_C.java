import java.util.*;
import java.io.*;

public class atcoder_AGC029_C {

    // Helper class/structure to represent the pairs (index, value) used in DP
    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    /**
     * Function equivalent to Python's cut(array, index).
     * Finds the split point based on index and array values.
     * array is List<Pair>, index is int (1-based index for the cut point)
     */
    static List<Pair> cut(List<Pair> array, int index) {
        if (index < 1) {
            return new ArrayList<>();
        }

        // array[0] is the first element
        if (index <= array.get(0).index) {
            List<Pair> result = new ArrayList<>();
            result.add(new Pair(index, array.get(0).value));
            return result;
        }

        // Iterate backwards to find the split point
        // We are looking for the largest i such that array[i-1].index < index
        for (int i = array.size() - 1; i > 0; i--) {
            // Check if the index of the previous element is less than the target index
            if (array.get(i - 1).index < index) {
                // Return array[:i] + [(index, array[i].value)]
                List<Pair> result = new ArrayList<>(array.subList(0, i));
                result.add(new Pair(index, array.get(i).value));
                return result;
            }
        }

        // Should not be reached if input constraints guarantee a solution, 
        // but if no cut is found, return empty list or handle error.
        return new ArrayList<>();
    }

    /**
     * Function equivalent to Python's is_possible(K).
     * A is the input array of values.
     */
    static boolean is_possible(int K, int[] A) {
        if (A.length == 0) return true;

        // dp stores List<Pair>
        List<Pair> dp = new ArrayList<>();
        // Initial state: (A[0], 0)
        dp.add(new Pair(A[0], 0));

        for (int a : A) {
            // 1. Try to incorporate 'a' into the current segment
            if (a <= dp.get(dp.size() - 1).index) {
                // If 'a' fits, perform the cut operation
                dp = cut(dp, a);
            } else {
                // If 'a' doesn't fit, start a new segment: (a, 0)
                dp.add(new Pair(a, 0));
            }

            // 2. Try to optimize by cutting previous segments
            boolean is_added = false;
            
            // Iterate backwards through dp
            for (int j = dp.size() - 1; j >= 0; j--) {
                Pair currentPair = dp.get(j);
                
                // Check if we can potentially increase the value of the segment ending at j
                if (currentPair.value < K - 1) {
                    // Perform the cut: dp = cut(dp, dp[j][0] - 1) + [(dp[j][0], dp[j][1] + 1)]
                    
                    // Get the list before the cut point
                    List<Pair> cutResult = cut(dp, currentPair.index - 1);
                    
                    // Add the new extended pair
                    List<Pair> newPair = new
