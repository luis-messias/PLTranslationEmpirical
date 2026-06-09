import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class s951065247 {

    // Global variables to hold input parameters for easy access in the recursive function
    static long A_target, B_target, C_target;
    static long[] l;
    static int N;

    /**
     * Performs Depth First Search to find the minimum cost.
     * @param cur The current index in the array l.
     * @param a Current sum for dimension A.
     * @param b Current sum for dimension B.
     * @param c Current sum for dimension C.
     * @return The minimum cost achievable from this state.
     */
    public static long dfs(int cur, long a, long b, long c) {
        // Base Case: All elements processed
        if (cur == N) {
            // Calculate cost: abs(A - a) + abs(B - b) + abs(C - c) - 30
            long cost = Math.abs(A_target - a) + Math.abs(B_target - b) + Math.abs(C_target - c) - 30;
            
            // Check condition: min(a, b, c) > 0
            if (Math.min(a, Math.min(b, c)) > 0) {
                return cost;
            } else {
                // Return 10^9 if condition fails
                return 1_000_000_000L;
            }
        }

        // 1. No addition (Skip l[cur])
        long no_add = dfs(cur + 1, a, b, c);

        // 2. Add to A
        // Note: The original Python code adds 10 to the result of the recursive call.
        long add_a = dfs(cur + 1, a + l[cur], b, c) + 10;

        // 3. Add to B
        long add_b = dfs(cur + 1, a, b + l[cur], c) + 10;

        // 4. Add to C
        long add_c = dfs(cur + 1, a, b, c + l[cur]) + 10;

        // Return the minimum of the four options
        return Math.min(no_add, Math.min(add_a, Math.min(add_b, add_c)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, A, B, C
        N = scanner.nextInt();
        A_target = scanner.nextLong();
        B_target = scanner.nextLong();
        C_target = scanner.nextLong();

        // Read array l
        l = new long[N];
        for (int i = 0; i < N; i++) {
            l[i] = scanner.nextLong();
        }

        // Start DFS from index 0 with initial sums (0, 0, 0)
        System.out.println(dfs(0, 0, 0, 0));
        
        scanner.close();
    }
}