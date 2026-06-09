import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC024_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // main() logic
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }
        
        // Call editorial(N, P)
        editorial(N, P);
        
        // Note: The original Python code defines WA but never calls it from main().
        // We only translate the execution path defined in main().
        
        scanner.close();
    }

    public static void editorial(int N, int[] P) {
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // a[k] stores the index i such that P[i] = k
        // Size N+1 because values in P can range up to N (if 1-indexed, but since N is the length, values are likely 1 to N)
        // Assuming values in P are positive and <= N.
        int[] a = new int[N + 1];
        
        // Initialize a with -1 or some indicator that the value hasn't been seen, 
        // although the Python code implicitly assumes all values 1..N are present.
        // We follow the Python logic:
        for (int i = 0; i < N; i++) {
            int p = P[i];
            a[p] = i;
        }

        int tmp = 1;
        int maxLen = 1;
        
        // Iterate from i = 1 to N - 1
        for (int i = 1; i < N; i++) {
            // Check if index of value i is less than index of value i+1
            if (a[i] < a[i + 1]) {
                tmp += 1;
                maxLen = Math.max(maxLen, tmp);
            } else {
                tmp = 1;
            }
        }
        
        int ans = N - maxLen;
        System.out.println(ans);
    }

    // WA function is defined in Python but not called by main(). 
    // We include it for completeness of translation, but it won't affect the output.
    public static void WA(int N, int[] P) {
        int tmp = 0;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            int p = P[i];
            
            // Check if i == 0 OR P[i-1] + 1 == P[i]
            if (i == 0 || P[i - 1] + 1 == p) {
                tmp += 1;
            } else {
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
        }
        
        // Note: The original Python code fails to update ans with the final tmp value.
        // We replicate this behavior.
        System.out.println(N - ans);
    }
}