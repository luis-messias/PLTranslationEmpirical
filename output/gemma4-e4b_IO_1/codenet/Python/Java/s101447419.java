import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class s101447419 {

    // Helper class to store element and its count
    static class ElementCount {
        int element;
        int count;

        public ElementCount(int element, int count) {
            this.element = element;
            this.count = count;
        }
    }

    /**
     * Calculates the top K most common elements from the frequency map.
     * Returns a list of ElementCount objects, sorted by count descending.
     */
    private static List<ElementCount> getTopK(Map<Integer, Integer> counts, int k) {
        if (counts == null || counts.isEmpty()) {
            return new ArrayList<>();
        }

        List<ElementCount> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            list.add(new ElementCount(entry.getKey(), entry.getValue()));
        }

        // Sort by count descending
        list.sort((a, b) -> Integer.compare(b.count, a.count));

        // Return top K
        return list.stream().limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read V
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        
        // Split V into ve (even indices) and vo (odd indices)
        List<Integer> ve = new ArrayList<>();
        List<Integer> vo = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ve.add(v[i]);
            } else {
                vo.add(v[i]);
            }
        }

        // Calculate frequency counters
        Map<Integer, Integer> ce = new HashMap<>();
        for (int x : ve) {
            ce.put(x, ce.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> co = new HashMap<>();
        for (int x : vo) {
            co.put(x, co.getOrDefault(x, 0) + 1);
        }

        // Get top common elements lists
        List<ElementCount> topCe = getTopK(ce, 2
