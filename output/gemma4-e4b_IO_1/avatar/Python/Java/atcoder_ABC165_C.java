import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC165_C {

    private static int maxScore = 0;
    private static int N, M, Q;
    private static int[] a, b, c, d;

    public static void solve(int N, int M, int Q, int[] a, int[] b, int[] c, int[] d) {
        // Set static class variables to hold the problem state
        atcoder_ABC165_C.N = N;
        atcoder_ABC165_C.M = M;
        atcoder_ABC165_C.Q = Q;
        atcoder_ABC165_C.a = a;
        atcoder_ABC165_C.b = b;
        atcoder_ABC165_C.c = c;
        atcoder_ABC165_C.d = d;
        
        maxScore = 0;
        
        // currentSequence stores the sequence A of length N
        int[] currentSequence = new int[N];
        
        // Start recursion from index 0
        rec(0, currentSequence);
        
        System.out.println(maxScore);
    }

    /**
     * Recursive function to generate all non-decreasing sequences of length N.
     * @param k The current index being filled (0 to N-1).
     * @param currentSequence The array storing the sequence being built.
     */
    private static void rec(int k, int[] currentSequence) {
        if (k == N) {
            // Base case: Sequence A is complete
            int currentScore = 0;
            for (int i = 0; i < Q; i++) {
                // Check condition: A[b[i] - 1] - A[a[i] - 1] == c[i]
                // Note: Input indices a[i] and b[i] are 1-based.
                // Array indices are 0-based.
                
                // Get values from the sequence A (currentSequence)
                int valB = currentSequence[b[i] - 1];
                int valA = currentSequence[a[i] - 1];
