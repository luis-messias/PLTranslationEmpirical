import java.util.*;
import java.io.*;

public class atcoder_ABC167_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n, m, x
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int x = Integer.parseInt(line1[2]);

        // Read matrix c (n rows, m columns)
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                c[i][j] = Integer.parseInt(row[j]);
            }
        }

        // pre = [0, 1, ..., n-1]
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pre.add(i);
        }

        // l stores all combinations of indices from pre
        List<List<Integer>> l = new ArrayList<>();
        
        // Generate combinations (similar to itertools.combinations)
        // i represents the size of the combination, from 1 to n
        for (int iSize = 1; iSize <= n; iSize++) {
            List<List<Integer>> combinations = generateCombinations(pre, iSize);
            l.addAll(combinations);
        }

        List<Integer> rem = new ArrayList<>();
        
        // Main loop: i from 1 to m
        for (int i = 1; i <= m; i++) {
            // Iterate over l (combinations)
            for (int j = 0; j < l.size(); j++) {
                List<Integer> k = l.get(j); // Combination of row indices
                long ca = 0;
                
                // Calculate sum: sum(c[ii, i] for ii in k)
                for (int ii : k) {
                    // Check bounds just in case, although based on Python logic, ii should be valid row index
                    if (ii < n && i < m) {
                        ca += c[ii][i];
                    }
                }

                if (ca < x) {
                    rem.add(j); // Store index j of combination in l
                }
            }

            // Pruning step
            if (!rem.isEmpty()) {
                // Remove elements from l based on rem (must iterate backwards or use a temporary list)
                // Python: for j in rem: l.pop(j)
                // Since we are removing based on indices, we must handle the list modification carefully.
                
                // Create a list of indices to remove, sorted descendingly to avoid index shifting issues
                List<Integer> indicesToRemove = new ArrayList<>(rem);
                Collections.sort(indicesToRemove, Collections.reverseOrder());
                
                for (int indexToRemove : indicesToRemove) {
                    if (indexToRemove < l.size()) {
                        l.remove(indexToRemove);
                    }