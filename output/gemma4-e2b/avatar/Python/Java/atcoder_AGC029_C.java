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

    // Function equivalent to Python's cut(array, index)
    // array is List<Pair>, index is int
    static List<Pair> cut(List<Pair> array, int index) {
        if (index < 1) {
            return new ArrayList<>();
        }
        
        // array[0][0] is array.get(0).index
        // array[0][1] is array.get(0).value
        if (index <= array.get(0).index) {
            List<Pair> result = new ArrayList<>();
            result.add(new Pair(index, array.get(0).value));
            return result;
        }

        // Iterate backwards
        for (int i = array.size() - 1; i > 0; i--) {
            // array[i-1][0] is the index of the previous element
            if (array.get(i - 1).index < index) {
                List<Pair> result = new ArrayList<>(array.subList(0, i));
                result.add(new Pair(index, array.get(i).value));
                return result;
            }
        }
        
        // Should not be reached if logic is sound, but return empty list if no cut found
        return new ArrayList<>();
    }

    // Function equivalent to Python's is_possible(K)
    static boolean is_possible(int K, int[] A) {
        // dp stores List<Pair>
        List<Pair> dp = new ArrayList<>();
        dp.add(new Pair(A[0], 0));

        for (int a : A) {
            if (a <= dp.get(dp.size() - 1).index) {
                dp = cut(dp, a);
            } else {
                dp.add(new Pair(a, 0));
            }

            boolean is_added = false;
            // Iterate backwards through dp
            for (int j = dp.size() - 1; j >= 0; j--) {
                if (dp.get(j).value < K - 1) {
                    // dp = cut(dp, dp[j][0] - 1) + [(dp[j][0], dp[j][1] + 1)]
                    List<Pair> cutResult = cut(dp, dp.get(j).index - 1);
                    List<Pair> newPair = new ArrayList<>();
                    newPair.add(new Pair(dp.get(j).index, dp.get(j).value + 1));
                    cutResult.add(newPair);
                    
                    dp = new ArrayList<>(cutResult);
                    
                    // if dp[-1][0] < a: dp += [(a, 0)]
                    if (dp.get(dp.size() - 1).index < a) {
                        dp.add(new Pair(a, 0));
                    }
                    
                    is_added = true;
                    break;
                }
            }
            
            if (!is_added) {
                return false;
            }
        }
        return true;
    }

    // Function equivalent to Python's bis(x, y)