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
        // Note: The Python code calculates distance between (x[t], y[t]) and (x[f], y[f])
        // where f and t are indices.
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
                // Calculate distance between consecutive points in the path
                totalDistance += calculateDistance(startIndex, endIndex);
            }
            distances.add(totalDistance);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPath[depth] = i;
                generatePermutations(currentPath, used, depth + 1);
                used[i] = false; // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        N = scanner.nextInt();
        
        // Initialize arrays
        x = new int[N];
        y = new int[N];
        
        // Read coordinates
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // Solve
        if (N == 0) {
            System.out.println(0.0);
            return;
        }
        
        int[] currentPath = new int[N];
        boolean[] used = new boolean[N];
        
        generatePermutations(currentPath, used, 0);
        
        // Calculate result: average of all total distances
        if (distances.isEmpty()) {
            // This should only happen if N=1, in which case there are no segments, 
            // but the average calculation requires division by N! > 0.
            // If N=1, the loop for totalDistance runs 0 times, totalDistance=0.
            // The number of permutations is 1. The average is 0.
            if (N == 1) {
                System.out.println(0.0);
            } else {
                // Should not happen given the logic, but safe guard.
                System.out.println(0.0);
            }
        } else {
            double sumOfDistances = 0.0
