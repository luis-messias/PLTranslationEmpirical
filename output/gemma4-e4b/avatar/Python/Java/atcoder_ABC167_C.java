import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class atcoder_ABC167_C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, M, X
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();

        // Read matrix C (N rows, M columns)
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        // 1. Generate all non-empty combinations of indices {0, 1, ..., N-1}
        List<List<Integer>> l = generateCombinations(n);

        // 2. Main filtering loop (i = 1 to m)
        List<Integer> remIndices = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            remIndices.clear();

            // Iterate over all current combinations in l
            for (int j = 0; j < l.size(); j++) {
                List<Integer> k = l.get(j);
                long ca = 0;

                // Calculate sum for column i
                for (int ii : k) {
                    ca += c[ii][i - 1]; // Column index is i-1 since i is 1-based
                }

                if (ca < x) {
                    remIndices.add(j);
                }
            }

            // Pruning l
            if (!remIndices.isEmpty()) {
                // Must remove elements in descending order of index to maintain correctness
                Collections.sort(remIndices, Collections.reverseOrder());
                for (int index : remIndices) {
                    l.remove(index);
                }
            }

            // Termination check
            if (l.isEmpty()) {
                System.out.println(-1);
                return;
            }
        }

        // 3. Final calculation (Column 0)
        if (l.isEmpty()) {
            // Should have been caught above, but safety check
            System.out.println(-1);
            return;
        }

        long ans = Long.MAX_VALUE;
        boolean first = true;

        for (List<Integer> i : l) {
            long ca = 0;
            // Calculate sum for column 0
            for (int j : i) {
                ca += c[j][0];
            }

            if (first) {
                ans = ca;
                first = false;
            } else {
                ans = Math.min(ans, ca);
            }
        }

        System.out.println(ans);
    }

    /**
     * Generates all non-empty combinations (subsets) of indices {0, 1, ..., n-1}.
     * This mimics itertools.combinations for all sizes 1 to n.
     */
    private static List<List<Integer>> generateCombinations(int n) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        
        // Iterate through all possible subsets using bitmasks (2^n - 1 non-empty subsets)
        // Mask goes from 1 (00...01) to 2^n - 1 (11...11)
        int totalSubsets = 1 << n;
        
        for (int mask = 1; mask < totalSubsets; mask++) {
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // Check if the i-th bit is set in the mask
                if ((mask & (1 << i)) != 0) {
                    combination.add(i);
                }
            }
            allCombinations.add(combination);
        }
        return allCombinations;
    }
}