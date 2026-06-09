import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC155_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        Arrays.sort(A);

        long ll = -1000000000000L;
        long rr = 1000000000001L;

        while (ll + 1 < rr) {
            long x = (ll + rr) / 2;
            int tot = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] < 0) {
                    int l = -1, r = N;
                    while (l + 1 < r) {
                        int c = (l + r) / 2;
                        if (Math.abs(A[i]) * Math.abs(A[c]) <= x) {
                            r = c;
                        } else {
                            l = c;
                        }
                    }
                    tot += N - r;
                } else {
                    int l = -1, r = N;
                    while (l + 1 < r) {
                        int c = (l + r) / 2;
                        if (Math.abs(A[i]) * Math.abs(A[c]) <= x) {
                            l = c;
                        } else {
                            r = c;
                        }
                    }
                    tot += r;
                }
                if (A[i] * A[i] < x) {
                    tot--;
                }
            }
            tot /= 2;
            if (tot < K) {
                ll = x;
            } else {
                rr = x;
            }
        }

        System.out.println(ll);
    }
}
