import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class atcoder_ABC105_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M;
        N = scanner.nextInt();
        M = scanner.nextInt();

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }

        long[] cum_remainders = new long[M + 1];
        for (int i = 1; i <= M; i++) {
            cum_remainders[i] = (A[i - 1] % M + cum_remainders[i - 1]) % M;
        }

        Map<Long, Long> remainder_counts = new HashMap<>();
        for (long value : cum_remainders) {
            remainder_counts.put(value, remainder_counts.getOrDefault(value, 0L) + 1);
        }

        long combinations = 0;
        for (Map.Entry<Long, Long> entry : remainder_counts.entrySet()) {
            long count = entry.getValue();
            combinations += count * (count - 1) / 2;
        }
        System.out.println(combinations);
    }
}