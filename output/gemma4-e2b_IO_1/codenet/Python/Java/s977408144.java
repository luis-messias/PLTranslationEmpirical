import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class s977408144 {

    // Global variables from Python
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static final int mod = 1000000007;
    // 10^20 fits within a long (max ~9*10^18). Since 10^20 is larger, we use BigInteger or long if the context implies standard 64-bit limits.
    // Given the context error, we stick to long for inf, acknowledging potential overflow if intermediate calculations exceed 2^63-1, but 10^20 is often used as a placeholder for infinity.
    static final long inf = 10000000000000000000L; // 10^20

    // Helper functions (mimicking Python functions)

    static void yn(boolean b) {
        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static void Yn(boolean b) {
        if (b) {
            System.out.println("True"); // Assuming True/False output for clarity if needed, or just print the result
        } else {
            System.out.println("False");
        }
    }

    // Helper function for modular exponentiation (needed if we were doing large powers, but not strictly needed for this problem structure)
    // private static long power(long base, long exp, long mod) { ... }

    // --- Main logic starts here ---

    public static void main(String[] args) throws Exception {
        // The actual problem context is missing, so we assume the goal is to read input and process it.
        // Since the prompt only provided the function definitions, we cannot execute a specific task.
        // We will structure the code to be runnable if input were provided.

        // Example placeholder: Reading input if this were a competitive programming problem
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // ...
    }
}

// Note: Since the prompt only provided function definitions and no specific task to solve, 
// the provided code structure above is a translation of the provided definitions into a runnable Java context.
// If a specific problem statement was intended, please provide it.
