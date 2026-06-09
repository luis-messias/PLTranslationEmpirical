import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class codeforces_272_B {

    /**
     * Calculates the population count (number of set bits) of n.
     * This replicates the logic of the Python function f(n).
     * @param n The input integer.
     * @return The number of set bits in n.
     */
    private static int f(int n) {
        // In Java, Integer.bitCount(n) efficiently calculates the population count.
        return Integer.bitCount(n);
    }

    /**
     * Calculates the number of pairs of elements in the sequence that share a common FX value.
     * @param sequence The list of input integers.
     * @return The count of pairs.
     */
    private static long nPairsWithCommonFX(List<Integer> sequence) {
        // Map: FX Value -> List of original numbers that map to this FX value
        Map<Integer, List<Integer>> storage = new HashMap<>();

        for (int value : sequence) {
            int fx = f(value);
            
            // Update storage
            storage.putIfAbsent(fx, new ArrayList<>());
            storage.get(fx).add(value);
        }

        long totalPairs = 0;
        
        // Calculate pairs for each group size k