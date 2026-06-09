import java.util.Scanner;

public class codeforces_373_B {
    public static int sum(int k) {
        long ret = 0;
        long pw = 10;
        int len = 1;
        while (true) {
            int cur = Math.min((int)(pw - 1), k);
            int prev = (int)(pw / 10);
            ret += (cur - prev + 1) * len;
            if ((pw - 1) >= k) break;
            len++;
            pw *= 10;
        }
        return (int)ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w, m, k;
        w = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int lo = 0;
        int hi = Integer.MAX_VALUE / 2;
        while (hi - lo > 1) {
            int md = (lo + hi) / 2;
            int c = sum(m + md) - sum(m - 1);
            if ((long)c * k <= w) lo = md;
            else hi = md;
        }
        System.out.println(lo);
    }
}
