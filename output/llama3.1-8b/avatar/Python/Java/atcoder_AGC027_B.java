import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class atcoder_AGC027_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] input = br.readLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);
        int[] A = Arrays.stream(input, 2, input.length)
                .mapToInt(Integer::parseInt).toArray();

        long[] S = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            S[i] = sum;
        }

        long ans = Long.MAX_VALUE;
        for (int k = 1; k <= N / 2 + 1; k++) {
            int start = Math.max(0, N - 2 * k - 1);
            long E = k * X + 2 * Arrays.stream(S, start, N)
                    .mapToLong(i -> i).sum();
            ans = Math.min(ans, E);
        }

        System.out.println(ans + N * X + 5 * S[S.length - 1]);
    }
}