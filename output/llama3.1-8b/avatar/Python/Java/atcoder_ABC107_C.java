import java.util.Scanner;

public class atcoder_ABC107_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] lst = new int[N];
        for (int i = 0; i < N; i++) {
            lst[i] = scanner.nextInt();
        }
        int[] lst_p = new int[K];
        int[] lst_m = new int[(N - K)];
        int p = 0;
        int m = 0;
        int x = 0;
        int y = (N - K) - 1;
        int lastx = K;
        int lasty = (N - K);

        int check(int k) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j <= k; j++) {
                if (j > lastx || k - j > lasty) {
                    continue;
                } else {
                    if (j == 0) {
                        p = 0;
                    } else {
                        p = lst_p[j - 1];
                    }
                    if (k - j == 0) {
                        m = 0;
                    } else {
                        m = lst_m[lasty - (k - j)];
                    }
                    ans = Math.min(ans, 2 * p + Math.abs(m), p + 2 * Math.abs(m));
                }
            }
            return ans;
        }

        System.out.println(check(K));
    }
}