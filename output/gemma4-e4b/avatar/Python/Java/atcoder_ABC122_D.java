import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC122_D {

    private static int N;
    private static final long MOD = 1_000_000_007L;
    // memo[cur] maps last3 (String) -> count (Long)
    private static Map<String, Long>[] memo;

    /**
     * Checks if the 4-character string 'last4' is "okay" based on the specific swapping rule.
     * It checks the original string and the strings resulting from swapping (i, i-1) for i=1, 2, 3.
     */
    private static boolean ok(String last4) {
        char[] originalChars = last4.toCharArray();

        for (int i = 0; i < 4; i++) {
            // Create a fresh copy of the characters for each iteration
            char[] t = originalChars.clone();

            // Perform the swap if i >= 1
            if (i >= 1) {
                // Swap t[i] and t[i-1]
                char temp = t[i];
                t[i] = t[i - 1];
                t[i - 1] = temp;
            }

            String currentString = new String(t);

            // Check for "AGC"
            if (currentString.contains