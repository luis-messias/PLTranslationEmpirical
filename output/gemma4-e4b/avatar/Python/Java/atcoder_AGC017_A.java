import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_AGC017_A {

    /**
     * Calculates N choose K (binomial coefficient).
     * Uses long to prevent overflow for intermediate calculations.
     */
    public static long combi(int N, int K) {
        if (K < 0 || K > N) {
            return 0;
        }
        if (K == 0 || K == N) {
            return 1;
        }
        // Optimization: C(N, K) = C(N, N-K)
        if (K > N / 2) {
            K = N - K;
        }

        long res = 1;
        // Calculate (N * (N-1) * ... * (N-K+1)) / K!
        for (int i = 0; i < K; i++) {
            // We multiply by (N-i) and then divide by (i+1)
            // This sequence guarantees that the result remains an integer
            // and keeps the intermediate product manageable.
            res = res * (N - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N and P
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        int P = scanner.nextInt();

        // 2. Read the list of integers (lis)
        List<Integer> lis = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lis.add(scanner.nextInt());
        }
        scanner.close();

        // 3. Calculate parity list (ls) and counts
        int one = 0;
        int zero = 0;
        for (int num : lis) {
            if (num % 2 == 1) {
                one++;
            } else {
                zero++;
            }
        }

        // 4. Calculate pattern_b: Sum C(zero, j) for j=0 to zero
        // This sum equals 2^zero
        long pattern_b = 0;
        for (int j = 0; j <= zero; j++) {
            pattern_b += combi(zero, j);
        }

        // 5. Calculate pattern_a: Sum C(one, time) where time % 2 == P
        long pattern_a = 0;
        for (int time = 0; time <= one; time++) {
            if (time % 2 == P) {
                pattern_a += combi(one, time);
            }
        }

        // 6. Print the result
        // The Python code casts the final product to int, but since pattern_a and pattern_b
        // can be large (up to 2^N), we must use long for the product.
        System.out.println(pattern_a * pattern_b