import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_AGC019_A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int q = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        int d = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int best1L = Math.min(q * 4, h * 2, s);
        int best2L = Math.min(d, best1L * 2);

        if (n % 2 == 0) {
            System.out.println(best2L * (n / 2));
        } else {
            System.out.println(best2L * (n / 2) + best1L);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd((int)a, (int)b);
    }
}
