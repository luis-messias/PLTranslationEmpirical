import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC024_B {

    public static void editorial(int N, int[] P) {
        if (N == 1) {
            System.out.println(0);
            return;
        }
        // a is 1-indexed conceptually, size N+1
        int[] a = new int[N + 1];
        
        // Map values in P to their indices (0 to N-1)
        for (int i = 0; i < N; i++) {
            // P[i] is the value, i is the index
            // We assume P[i] is a valid index for a (1 to N)
            a[P[i]] = i;
        }

        int tmp = 1;
        int max_len = 1;
        
        // Iterate from i=1 to N-1 (comparing a[i] and a[i+1])
        for (int i = 1; i < N; i++) {
            if (a[i] < a[i + 1]) {
                tmp += 1;
                max_len = Math.max(max_len, tmp);
            } else {
                tmp = 1;
            }
        }
        
        // The result is N - max_len
        System.out.println(N - max_len);
    }

    public static void WA(int N, int[] P) {
        int tmp = 0;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            int p = P[i];
            // Check if it's the first element OR if the current element is exactly 1 greater than the previous element
            if (i == 0 || P[i - 1] + 1 == p) {
                tmp += 1;
            } else {
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
        }