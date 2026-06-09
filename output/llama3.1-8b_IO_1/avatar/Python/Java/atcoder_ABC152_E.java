import java.util.Scanner;
import java.math.BigInteger;

public class atcoder_ABC152_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        BigInteger lcm = BigInteger.ONE;
        for (int a : A) {
            lcm = lcm.multiply(BigInteger.valueOf(a)).divide(gcd(lcm, BigInteger.valueOf(a)));
        }
        int sum = 0;
        for (int s : A) {
            sum += pow(s, MOD - 2, MOD);
        }
        System.out.println((lcm.multiply(BigInteger.valueOf(sum))).mod(BigInteger.valueOf(MOD)).longValue());
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int pow(int s, int e, int mod) {
        int result = 1;
        while (e > 0) {
            if ((e & 1) != 0)
                result = (int) (((long) result * s) % mod);
            s = (int) (((long) s * s) % mod);
            e >>= 1;
        }
        return result;
    }

    private static final int MOD = 1000000007;
}
