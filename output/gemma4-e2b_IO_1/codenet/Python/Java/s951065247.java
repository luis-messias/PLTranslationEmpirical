import java.util.Scanner;

public class s951065247 {

    static int N, A, B, C;
    static int[] L;

    // DFS function definition
    public static long dfs(int cur, int a, int b, int c) {
        if (cur == N) {
            long cost = Math.abs(A - a) + Math.abs(B - b) + Math.abs(C - c);
            
            // Python logic: abs(A - a) + abs(B - b) + abs(C - c) - 30 if min(a, b, c) > 0 else 10 ** 9
            if (Math.min(a, Math.min(b, c)) > 0) {
                return cost - 30;
            } else {
                // Use a very large value for the sentinel, ensuring it's larger than any possible valid result.
                return Long.MAX_VALUE; 
            }
        }

        // Option 1: Do nothing (don't add L[cur] to a, b, or c)
        long no_add = dfs(cur + 1, a, b, c);

        // Option 2: Add L[cur] to a
        long add_a = dfs(cur + 1, a + L[cur], b, c) + 10;

        // Option 3: Add L[cur] to b
        long add_b = dfs(cur + 1, a, b + L[cur], c) + 10;

        // Option 4: Add L[cur] to c
        long add_c = dfs(cur + 1, a, b, c + L[cur]) + 10;

        return Math.min(no_add, Math.min(add_a, Math.min(add_b, add_c)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.
