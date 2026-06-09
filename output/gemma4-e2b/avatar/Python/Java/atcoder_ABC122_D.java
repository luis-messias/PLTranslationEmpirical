import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC122_D {

    private static long[][][] memo;
    private static int N;
    private static long MOD = 1_000_000_007;

    // Function equivalent to ok(last4)
    private static boolean ok(String last4) {
        // The Python implementation performs swaps and checks for 'AGC'.
        // Since the goal is to check if any permutation of last4 contains 'AGC',
        // and the swapping logic is complex, we simplify the check based on the intent
        // of sequence constraints, assuming the intent is to check if 'AGC' exists
        // as a substring in any arrangement of the characters in last4.
        // A simpler, direct check for 'AGC' presence in any permutation is sufficient
        // if the constraint is about the set of characters, but we must follow the logic structure.

        // Let's replicate the exact logic:
        String current = last4;
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder(current);
            
            // Simulate the swapping logic exactly as written in Python
            String t = current;
            for (int j = 1; j <= 4; j++) {
                if (j >= 1) {
                    char c1 = t.charAt(j);
                    char c0 = t.charAt(j - 1);
                    if (c1 != c0) {
                        char temp = t.charAt(j);
                        t.setCharAt(j, c0);
                        t.setCharAt(j - 1, temp