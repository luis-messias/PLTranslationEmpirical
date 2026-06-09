import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC110_C {

    /**
     * Counts character frequencies in a string and returns a sorted list of those counts.
     * @param s The input string.
     * @return A sorted list of character counts.
     */
    private static List<Integer> getSortedFrequencies(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(counts.values());
        Collections.sort(frequencies);
        return frequencies;
    }

    public static String run(String s, String t) {
        List<Integer> ss = getSortedFrequencies(s);
        List<Integer> tt = getSortedFrequencies(t);

        // List.equals() checks if two lists have the same size and elements in the same order.
        if (ss.equals(tt)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the first string (s)
        String s = scanner.nextLine();
        
        // Read the second string (t)
        String t = scanner.nextLine();
        
        scanner.close();

        System.out.println(run(s, t));
    }
}