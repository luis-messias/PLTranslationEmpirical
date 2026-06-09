import java.util.*;
import java.util.stream.Collectors;

public class atcoder_ABC150_C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after n

        // 2. Generate all permutations (orig) of {1, 2, ..., n}
        List<List<Integer>> orig = generatePermutations(n);

        // 3. Read p (as a list of integers)
        if (!scanner.hasNextLine()) return;
        String lineP = scanner.nextLine();
        List<Integer> pList = Arrays.stream(lineP.split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        // 4. Read q (as a list of integers)
        if (!scanner.hasNextLine()) return;
        String lineQ = scanner.nextLine();
        List<Integer> qList = Arrays.stream(lineQ.split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        // 5. Find indices
        // Note: List.indexOf requires the list object to be present in the list.
        // Since permutations are lists of integers, we use List.indexOf(List) which requires careful handling,
        // or we rely on the fact that List implements equals/hashCode based on content if we were using Sets,
        // but for List<List<Integer>>, we must rely on the standard List.indexOf behavior if available, or convert to a comparable form.
        // Since List<List<Integer>> does not have a standard indexOf method that compares list contents,
        // we must iterate manually or rely on the fact that the permutation generation ensures unique permutations.

        int pn = -1;
        int qn = -1;

        for (int i = 0; i < orig.size(); i++) {
            if (orig.get(i).equals(pList)) {
                pn = i;
            }
            if (orig.get(i).equals(qList)) {
                qn = i;
            }
        }

        // 6. Calculate and print the absolute difference
        if (pn != -1 && qn != -1) {
            System.out.println(Math.abs(pn - qn));
        }
    }

    /**
     * Generates all permutations of the sequence {1, 2, ..., n}.
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
