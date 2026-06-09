public class codeforces_373_B {
    public static long sum(long k) {
        long ret = 0;
        long pw = 10;
        long len = 1;
        while (true) {
            long cur = Math.min(pw - 1, k);
            long prev = pw / 10;
            ret += (cur - prev + 1) * len;
            if (pw - 1 >= k) {
                break;
            }
            len++;
            pw *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        long w = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long lo = 0;
        long hi = 1000000000000000000L;

        while (hi - lo > 1) {
            long md = (lo + hi) / 2;
            long c = sum(m + md - 1) - sum(m - 1);
            if (c * k <= w) {
                lo = md;
            } else {
                hi = md;
            }
        }
        System.out.println(lo);
    }
}
