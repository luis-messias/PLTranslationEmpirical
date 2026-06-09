import java.util.*;
import java.io.*;

public class atcoder_AGC012_A {
    static long mod = (long)1e9 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(A);
        long ans = 0;
        for (int i = n - 2; i >= Math.max(n * 2 - 1, 0); i--) {
            if (i % 2 == n % 2) ans += A[i];
        }
        System.out.println(ans);
    }
}
