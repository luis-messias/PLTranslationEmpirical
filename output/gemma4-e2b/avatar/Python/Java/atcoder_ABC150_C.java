import java.util.*;
import java.util.stream.Collectors;

public class atcoder_ABC150_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // 2. Generate all permutations (orig) of {1, 2, ..., n}
        List<List<Integer>> orig = generatePermutations(n);

        // 3. Read p
        if (!scanner.hasNextLine()) return;
        String lineP = scanner.nextLine();
        scanner.nextLine(); // Consume newline if necessary, though nextInt/nextLine handling might be tricky if input is mixed.
        
        // Read P elements
        List<Integer> pList = Arrays.stream(lineP.split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());
        
        // 4. Read q
        if (!scanner.hasNextLine()) return;
        String lineQ = scanner.nextLine();
        
        // Read Q elements
        List<Integer> qList = Arrays.stream(lineQ.split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        // 5. Find indices
        int pn = orig.indexOf(pList);
        int qn = orig.indexOf(qList);

        // 6. Calculate and print the absolute difference
        if (pn != -1 && qn != -1) {
            System.out.println(Math.abs(pn - qn));
        }
    }

    /**
     * Generates all permutations of the sequence {1, 2, ..., n}.
     * This replicates itertools.permutations(list(range(1, n + 1))).
     */
    private static List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            elements.add(i);
        }

        permuteHelper(elements, 0, result);
        return result;
    }

    private static void permuteHelper(List<Integer> arr, int k, List<List<Integer>> result) {
        if (k == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = k; i < arr.size(); i++) {
            // Swap arr[k] and arr[i]
            Collections.swap(arr, k, i);
            permuteHelper(arr, k + 1, result);
            // Backtrack: swap back
            Collections.swap(arr, k, i);
        }
    }
}