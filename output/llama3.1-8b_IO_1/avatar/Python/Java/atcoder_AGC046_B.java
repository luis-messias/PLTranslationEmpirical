import java.util.Scanner;

public class atcoder_AGC046_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, C, D;
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        D = scanner.nextInt();

        long m = 998244353;
        long[][] d = new long[C + 1][D + 1];
        d[A][B] = 1;

        for (int i = A; i <= C; i++) {
            for (int j = B; j <= D; j++) {
                if (i > 0 && j > 0) {
                    d[i][j] += ((d[i][j - 1] * i) % m + (d[i - 1][j] * j) % m - (d[i - 1][j - 1] * (i - 1) * (j - 1)) % m);
                }
                d[i][j] %= m;
            }
        }

        System.out.println(d[C][D]);
    }
}
