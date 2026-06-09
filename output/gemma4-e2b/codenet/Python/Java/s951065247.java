import java.util.Scanner;
import java.util.Arrays;

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
                // 10**9 is a large sentinel value, use Long.MAX_VALUE or a sufficiently large number
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
        Scanner scanner = new Scanner(System.in);

        // Read N, A, B, C
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
            A = scanner.nextInt();
            B = scanner.nextInt();
            C = scanner.nextInt();
        } else {
            return;
        }

        // Read L array
        L = new int[N];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                L[i] = scanner.nextInt();
            }
        }
        
        // Start DFS from index 0 with initial values (0, 0, 0, 0)
        long result = dfs(0, 0, 0, 0);
        
        System.out.println(result);
        
        scanner.close();
    }
}