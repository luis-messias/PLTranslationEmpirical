import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC165_C {

    private static int maxScore = 0;
    private static int N, M, Q;
    private static int[] a, b, c, d;

    public static void solve(int N, int M, int Q, int[] a, int[] b, int[] c, int[] d) {
        Solution.N = N;
        Solution.M = M;
        Solution.Q = Q;
        Solution.a = a;
        Solution.b = b;
        Solution.c = c;
        Solution.d = d;
        
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
                
                if (valB - valA == c[i]) {
                    currentScore += d[i];
                }
            }
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // Determine the starting value for the current element A[k]
        int startValue;
        if (k == 0) {
            startValue = 1;
        } else {
            // Must be >= the previous element
            startValue = currentSequence[k - 1];
        }

        // Iterate through possible values for A[k]
        for (int i = startValue; i <= M; i++) {
            currentSequence[k] = i;
            rec(k + 1, currentSequence);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            // Handle empty input case if necessary
            return;
        }

        // Read N, M, Q
        N = scanner.nextInt();
        M = scanner.nextInt();
        Q = scanner.nextInt();

        // Initialize arrays
        a = new int[Q];
        b = new int[Q];
        c = new int[Q];
        d = new int[Q];

        // Read Q sets of parameters
        for (int i = 0; i < Q; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }
        
        scanner.close();

        solve(N, M, Q, a, b, c, d);
    }
}