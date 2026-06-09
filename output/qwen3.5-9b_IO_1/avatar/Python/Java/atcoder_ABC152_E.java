import java.util.Scanner;

public class atcoder_ABC152_E {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
    public static long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        
        long _lcm = 1;
        for (long a : A) {
            _lcm = _lcm * a / gcd(_lcm, a);
        }
        
        long MOD = 1000000007L;
        long sum = 0;
        for (long a : A) {
            sum = (sum + power(a, MOD - 2, MOD)) % MOD;
        }
        
        long ans = (_lcm % MOD * sum) % MOD;
        System.out.println(ans);
    }
}
