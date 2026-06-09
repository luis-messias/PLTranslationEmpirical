import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class atcoder_ABC150_C {

    /**
     * Generates all permutations of numbers from 1 to n.
     * @param n The upper bound of numbers (inclusive).
     * @return A list containing all permutations.
     */
    public static List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[n + 1]; // used[i] tracks if number i is used

        // Start the recursive generation process
        generate(n, used, currentPermutation, allPermutations);
        return allPermutations;
    }

    private static void generate(int n, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> allPermutations) {
        if (currentPermutation.size() == n) {
            // Found a complete permutation, add a copy
            allPermutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                // Choose
                used[i] = true;
                currentPermutation.add(i);

                // Explore
                generate(n, used, currentPermutation, allPermutations);

                // Unchoose (Backtrack)
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }
    }

    /**
     * Finds the index of a target permutation within the list of all permutations.
     * @param allPermutations The list containing all permutations.
     * @param target The permutation to find.
     * @return The index, or -1 if not found.
     */
    public static int findIndex(List<List<Integer>> allPermutations, List<Integer> target) {
        for (int i = 0; i < allPermutations.size(); i++) {
            List<Integer> current = allPermutations.get(i);
            if (current.equals(target)) {
                return i;
            }
        }
        return -1; // Should not happen if inputs are valid permutations
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int n = Integer.parseInt(lineN.trim());

        // 2. Generate all permutations
        List<List<Integer>> allPermutations = generatePermutations(n);

        // 3. Read P
        String lineP = br.readLine();
        if (lineP == null || lineP.isEmpty()) return;
        List<Integer> p = Arrays.stream(lineP.trim().split("\\s+"))
                                 .filter(s -> !s.isEmpty())
                                 .map(Integer::parseInt)
                                 .collect(Collectors.toList());

        // 4. Read Q
        String lineQ = br.readLine();
        if (lineQ == null || lineQ.isEmpty()) return;
        List<Integer> q = Arrays.stream(lineQ.trim().split("\\s+"))
                                 .filter(s -> !s.isEmpty())
                                 .map(Integer::parseInt)
                                 .collect(Collectors.toList());

        // 5. Find indices
        int pn = findIndex(allPermutations, p);
        int qn = findIndex(allPermutations, q);

        // 6. Calculate and print absolute difference
        System.out.println(Math.abs(pn - qn));
    }
}