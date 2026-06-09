import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class s828550015 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 1. Read x, y, a, b, c
        if (!scanner.hasNextInt()) return;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Helper function to read a line of space-separated integers
        // Since we don't know how many numbers are on the next line, 
        // we read until the next required input starts or EOF.
        // For competitive programming style, we assume the next line contains all elements.
        
        // Reading elements for p (Line 2)
        String lineP = scanner.nextLine().trim();
        List<Integer> listP = new ArrayList<>();
        if (!lineP.isEmpty()) {
            String[] tokensP = lineP.split("\\s+");
            for (String token : tokensP) {
                if (!token.isEmpty()) {
                    listP.add(Integer.parseInt(token));
                }
            }
        }

        // Reading elements for q (Line 3)
        String lineQ = scanner.nextLine().trim();
        List<Integer> listQ = new ArrayList<>();
        if (!lineQ.isEmpty()) {
            String[] tokensQ = lineQ.split("\\s+");
            for (String token : tokensQ) {
                if (!token.isEmpty()) {
                    listQ.add(Integer.parseInt(token));
                }
            }
        }

        // Reading elements for r (Line 4)
        String lineR = scanner.nextLine().trim();
        List<Integer> listR = new ArrayList<>();
        if (!lineR.isEmpty()) {
            String[] tokensR = lineR.split("\\s+");
            for (String token : tokensR) {
                if (!token.isEmpty()) {
                    listR.add(Integer.parseInt(token));
                }
            }
        }
        
        // --- Processing p ---
        // Sort descending and take top x
        listP.sort(Comparator.reverseOrder());
        List<Integer> p = listP.subList(0, Math.min(x, listP.size()));

        // --- Processing q ---
        // Sort descending and take top y
        listQ.sort(Comparator.reverseOrder());
        List<Integer> q = listQ.subList(0, Math.min(y, listQ.size()));

        // --- Processing r ---
        // Sort descending (all elements)
        listR.sort(Comparator.reverseOrder());
        List<Integer> r = listR;

        // --- Processing pq ---
        // Concatenate p and q
        List<Integer> pq = new ArrayList<>();
        pq.addAll(p);
        pq.addAll(q);
        
        // Sort pq ascending (Python's default sort behavior on concatenation)
        // Note: The Python code uses sorted(p+q), which sorts the combined list ascendingly.
        pq.sort(Comparator.naturalOrder());

        // --- Modification Loop ---
        int limit = Math.min(x + y, Math.min(a + b, c));
        
        // Ensure we don't go out of bounds for r
        int loopLimit = Math.min(limit, r.size());

        for (int i = 0; i < loopLimit; i++) {
            if (pq.get(i) < r.get(i)) {
                pq.set(i, r.get(i));
            }
        }

        // --- Summation ---
        long sum = 0;
        for (int val : pq) {
            sum += val;
        }

        System.out.println(sum);
    }
}