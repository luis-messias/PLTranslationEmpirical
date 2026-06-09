import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class s101447419 {

    // Helper class to store element and its count for sorting
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
        if (counts.isEmpty()) {
            return new ArrayList<>();
        }

        List<ElementCount> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            list.add(new ElementCount(entry.getKey(), entry.getValue()));
        }

        // Sort by count descending
        list.sort((a, b) -> Integer.compare(b.count, a.count));

        // Return top K
        return list.stream().limit(k).collect(Collectors.toList