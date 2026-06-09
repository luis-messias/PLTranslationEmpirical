import java.util.Scanner;
import java.math.BigInteger;

public class atcoder_AGC017_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        
        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            lis[i] = sc.nextInt();
        }
        
        int[] ls = new int[N];
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            ls[i] = lis[i] % 2;
            if (ls[i] == 1) {
                one++;
            } else {
                zero++;
            }
        }
        
        BigInteger pattern_a = BigInteger.ZERO;
        BigInteger pattern_b = BigInteger.ZERO;
        
        for (int j = 0; j <= zero; j++) {
            pattern_b = pattern_b.add(combi(zero, j));
        }
        
        int time = 0;
        while (time <= one) {
            if (time % 2 == P) {
                pattern_a = pattern_a.add(combi(one, time));
            }
            time++;
        }
        
        System.out.println(pattern_a.multiply(pattern_b));
    }
    
    public static BigInteger combi(int n, int k) {
        BigInteger a = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            a = a.multiply(BigInteger.valueOf(n - i));
        }
        for (int j = 0; j < k; j++) {
            a = a.divide(BigInteger.valueOf(j + 1));
        }
        return a;
    }
}
