import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_AGC017_A {

    // Function to calculate combinations C(N, K)
    // Implemented using long to prevent overflow during intermediate multiplication
    public static long combi(int N, int K) {
        if (K < 0 || K > N) {
            return 0;
        }
        if (K == 0 || K == N) {
            return 1;
        }
        if (K > N / 2) {
            K = N - K;
        }

        long res = 1;
        for (int i = 0; i < K; i++) {
            // Calculate (N - i) / (i + 1) iteratively to maintain integer arithmetic
            // This is safer than calculating N! / (K! * (N-K)!) directly if N is large.
            // We calculate (N * (N-1) * ... * (N-K+1)) / (K * (K-1) * ... * 1)
            res = res * (N - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and P from the first line
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int P = scanner.nextInt();

        // Read the list of numbers from the second line
        List<Integer> lis = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lis.add(scanner.nextInt());
        }
        scanner.close();

        // Step
