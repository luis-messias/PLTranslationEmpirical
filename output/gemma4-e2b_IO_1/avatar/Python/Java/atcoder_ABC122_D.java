import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC122_D {

    private static Map<String, Long> memo;
    private static int N;
    private static long MOD = 1_000_000_007;

    // Function equivalent to ok(last4)
    private static boolean ok(String last4) {
        // Replicate the exact logic: iterate 4 times, perform swaps, and check for 'AGC'.
        for (int i = 0; i < 4; i++) {
            // t is a list of characters derived from last4
            char[] t = last4.toCharArray();
            
            // Simulate the swapping logic exactly as written in Python
            // Note: The Python code uses t = list(last4) and modifies t.
            // Since we are checking permutations, we need to ensure the swaps are applied correctly 
            // based on the state of t at each iteration.
            
            // The Python code re-initializes t = list(last4) inside the loop, meaning each iteration 
            // starts from the original last4, and the swaps are applied sequentially to t.
            
            // Let's re-read the Python logic carefully:
            /*
            for i in range ( 4 ) :
                t = list ( last4 )  // t is reset to the original last4 in every iteration
                if i >= 1 :
                    t [ i ] , t [ i - 1 ] = t [ i - 1 ] , t [ i ]
                if ''.join ( t ).count ( 'AGC' ) >= 1 :
                    return False
            */
            
            // If t is reset every time, the swaps only affect the current iteration's check based on the initial last4
