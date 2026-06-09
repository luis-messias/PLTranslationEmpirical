import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class atcoder_AGC029_C {

    // Helper class to represent the (start, end) pair
    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    /**
     * Equivalent to Python's cut(array, index)
     * array is a list of Pairs (start, end)
     */
    public static List<Pair> cut(List<Pair> array, int index) {
        if (index < 1) {
            return new ArrayList<>();
        }

        // Case 1: index <= array[0][0]
        if (array.isEmpty() || index <= array.get(0).start) {
            return new ArrayList<>(Arrays.asList(new Pair(index, array.get(0).end)));
        }

        // Case 2: Loop backwards
        // Python: for _ in range ( len ( array ) - 1 , 0 , - 1 ) :
        // We look for the last segment index i (where i > 0) such that array[i-1].start < index
        
        int N = array.size();
        int targetIndex = -1;

        // Iterate from the second element (index 1) up to N-1
        for (int i = N - 1; i >= 1; i--) {
            if (array.get(i - 1).start < index) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex != -1) {
            // Return array[:targetIndex] + [(index, array[targetIndex][1])]
            List<Pair> result = new ArrayList<>(array.subList