import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class atcoder_ABC128_C {

    // Helper function to generate combinations (subsets) of a list
    private static List<List<Integer>> generateCombinations(List<Integer> elements, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 0 || k > elements.size()) {
            return result;
        }
        
        // Recursive helper function
        generateCombinationsRecursive(elements, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsRecursive(List<Integer> elements, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < elements.size(); i++) {
            current.add(elements.get(i));
            generateCombinationsRecursive(elements, k, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N and M
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        // 2. Read li (M
