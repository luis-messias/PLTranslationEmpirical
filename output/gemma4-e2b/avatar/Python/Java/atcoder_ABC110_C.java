import java.util.*;
import java.io.*;

public class atcoder_ABC110_C {
    public static String run(String s, String t) {
        // Calculate frequencies for s
        Map<Character, Integer> freqS = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);
        }

        // Calculate frequencies for t
        Map<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // Extract values (frequencies)
        List<Integer> ss = new ArrayList<>(freqS.values());
        List<Integer> tt = new ArrayList<>(freqT.values());

        // Sort them
        Collections.sort(ss);
        Collections.sort(tt);

        // Compare
        if (ss.equals(tt)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read s
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            // Read t
            if (scanner.hasNextLine()) {
                String t = scanner.nextLine();
                System.out.println(run(s, t));
            }
        }
        
        scanner.close();
    }
}