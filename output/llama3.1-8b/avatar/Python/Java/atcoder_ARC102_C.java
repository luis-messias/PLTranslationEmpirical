import java.util.Scanner;

public class atcoder_ARC102_C {
    static long mod = 998244353;
    static int __N = 8000;
    static long[] g1 = new long[__N + 10];
    static long[] g2 = new long[__N + 10];
    static long[] inverse = new long[__N + 10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        init();
        for (int i = 2; i <= K + 1; i++) {
            System.out.println(solve(i) % mod);
        }
    }

    static void init() {
        g1[0] = 1;
        g1[1] = 1;
        inverse[0] = 1;
        inverse[1] = 1;
        g2[0] = 1;
        g2[1] = 1;

        for (int i = 2; i <= __N + 1; i++) {
            g1[i] = (g1[i - 1] * i) % mod;
            inverse[i] = (-inverse[(int) (mod % i)] * (mod / i)) % mod;
            g2[i] = (g2[i - 1] * inverse[i]) % mod;
        }
    }

    static long cmb(int n, int r, int mod) {
        if (r < 0 || r > n)
            return 0;
        r = Math.min(r, n - r);
        return g1[n] * g2[r] * g2[n - r] % mod;
    }

    static long kumiawase(int p, int q) {
        return cmb(p + q - 1, q - 1, (int) mod);
    }

    static long solve(int n) {
        assert n <= K + 1;
        long ans = 0;
        int kumi = (n - 1) / 2;

        for (int p = kumi; p >= 0; p--) {
            if (p > N)
                break;
            ans += (long) Math.pow(2, p) * cmb(kumi, p, (int) mod) * kumiawase(N - p, p + (K - kumi * 2 - (n % 2 == 0 ? 1 : 0)));
            if (n % 2 == 0 && N - p - 1 >= 0)
                ans += (long) Math.pow(2, p) * cmb(kumi, p, (int) mod) * kumiawase(N - p - 1, p + (K - kumi * 2 - (n % 2 == 0 ? 1 : 0)));
        }
        return ans;
    }
}