import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC145_C {

    /**
     * Calculates the Euclidean distance between two points (x1, y1) and (x2, y2).
     */
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Solves the problem by iterating over all permutations of indices.
     * N: number of points
     * x, y: coordinates of the points
     */
    public static void solve(int N, int[] x, int[] y) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            indices.add(i);
        }

        List<List<Integer>> permutations = new ArrayList<>();
        // Generate all permutations of indices
        List<Integer> currentPermutation = new ArrayList<>(indices);
        
        // Using an iterative approach to generate permutations (similar to itertools.permutations)
        // Note: For N!, this is computationally intensive.
        do {
            permutations.add(new ArrayList<>(currentPermutation));
        } while (nextPermutation(currentPermutation));


        double totalDistanceSum = 0.0;
        int numPermutations = permutations.size();

        for (List<Integer> permutation : permutations) {
            double totalDistance = 0.0;
            
            // The Python code iterates over pairs (f, t) from the permutation: permutation[i] and permutation[i+1]
            for (int i = 0; i < N - 1; i++) {
                int f = permutation.get(i);
                int t = permutation.get(i + 1);
                
                // Calculate distance between point f and point t
                double dx = x[t] - x[f];
                double dy = y[t] - y[f];
                double distance = Math.sqrt(dx * dx + dy * dy);
                
                totalDistance += distance;
            }
            totalDistanceSum += totalDistance;
        }

        // Calculate the average distance
        double result = totalDistanceSum / numPermutations;
        System.out.println(result);
    }

    /**
     * Helper function to generate the next lexicographical permutation of a list of integers.
     * Based on the standard algorithm for next permutation.
     * Returns true if a next permutation exists, false otherwise (if it's the last permutation).
     */
    private static boolean nextPermutation(List<Integer> a) {
        int n = a.size();
        if (n < 2) return false;

        // 1. Find the largest index k such that a[k] < a[k + 1].
        int k = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                k = i;
                break;
            }
        }

        // If no such index exists, the permutation is the last permutation.
        if (k == -1) {
            // Reverse the whole list to get the first permutation (lexicographically smallest)
            Collections.reverse(a);
            return false;
        }

        // 2. Find the largest index l > k such that a[k] < a[l].
        int l = -1;
        for (int i = n - 1; i > k; i--) {
            if (a.get(k) < a.get(i)) {
                l = i;
                break;
            }
        }

        // 3. Swap a[k] and a[l].
        Collections.swap(a, k, l);

        // 4. Reverse the sequence a[k + 1] to the end.
        List<Integer> suffix = a.subList(k + 1, n);
        Collections.reverse(suffix);

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        // Read N
        int N = scanner.nextInt();

        // Read coordinates x and y
        int[] x = new int[N];