import java.util.Scanner;

public class s790754864 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int R = N - K;
        long mod = (long) 1e9 + 7;

        for (int i = 1; i <= K; i++) {
            if (N - K + 1 < i) {
                System.out.println(0);
            } else {
                long ans = (combin(R + 1, i) * comb(K - 1, i - 1)) % mod;
                System.out.println(ans);
            }
        }
    }

    public static long comb(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans = ans * (n - i) / (i + 1);
        }
        return ans;
    }
}