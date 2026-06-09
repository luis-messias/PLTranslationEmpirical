import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC145_C {
    
    private static int N;
    private static int[] x;
    private static int[] y;
    private static List<Double> distances = new ArrayList<>();

    /**
     * Calculates the Euclidean distance between points at indices i and j.
     */
    private static double calculateDistance(int i, int j) {
        double dx = x[i] - x[j];
        double dy = y[i] - y[j];
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Recursively generates all permutations of indices and calculates the total distance 
     * for each path, storing them in the distances list.
     * 
     * @param currentPath The array storing the current permutation being built.
     * @param used Boolean array tracking which indices have been used in the current path.
     * @param depth The current position being filled in the permutation (0 to N-1).
     */
    private static void generatePermutations(int[] currentPath, boolean[] used, int depth) {
        if (depth == N) {
            // A complete permutation (path) is formed. Calculate total distance.
            double totalDistance = 0.0;
            for (int i = 0; i < N - 1; i++) {
                int startIndex = currentPath[i];
                int endIndex = currentPath[i+1];
                totalDistance += calculateDistance(startIndex, endIndex);
            }
            distances