import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class codeforces_61_B {

    /**
     * Cleans a string by removing characters '-', ';', '_' and converting the rest to lowercase.
     * Equivalent to Python's f(s).
     */
    private static String f(String s) {
        // Remove specified characters and convert to lowercase
        return s.replaceAll("[-;_]", "").toLowerCase();
    }

    /**
     * Generates all permutations of the three input strings and stores the concatenated results.
     * Equivalent to the permutation logic in Python's solve().
     */
    private static Set<String> generatePermutations(String[] l) {
        Set<String> permutations = new HashSet<>();
        
        // Since the length is fixed at 3, we can manually generate all 3! = 6 permutations.
        String s1 = l[0];
        String s2 = l[1];
        String s3 = l[2];

        permutations.add(s1 + s2 + s3);
        permutations.add(s1 + s3 + s2);
        permutations.add(s2 + s1 + s3);
        permutations.add(s2 + s3 + s1);
        permutations.add(s3 + s1 + s2);
        permutations.add(s3 + s2 + s1);
        
        return permutations;
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read the three initial strings (Python's input())
        String s1_raw = br.readLine();
        String s2_raw = br.readLine();
        String s3_raw = br.readLine();

        // 2. Apply f() to get the processed strings
        String[] l = new String[3];
        l[0] = f(s1_raw);
        l[1] = f(s2_raw);
        l[2] = f(s3_raw);

        // 3. Generate all permutations and store them in a Set for O(1) lookup
        Set<String> permutations = generatePermutations(l);

        // 4. Read the number of test cases N (Python's inp())
        String nLine = br.readLine();
        if (nLine == null || nLine.isEmpty()) return;
        int N = Integer.parseInt(nLine.trim());

        // 5. Process N test cases
        for (int i = 0; i < N; i++) {
            // Read the input string (Python's instr())
            String inputRaw = br.readLine();
            if (inputRaw == null) break;
            
            // Apply f() to the input
            String processedInput = f(inputRaw);

            // Check if the processed input is in the set of permutations
            if (permutations.contains(processedInput)) {
                System.out.println("ACC");
            } else {
                System.out.println("WA");
            }
        }
    }

    public static void main(String[] args) {
        try {
            solve();
        } catch (IOException e) {
            // Handle potential IO exceptions
        }
    }
}