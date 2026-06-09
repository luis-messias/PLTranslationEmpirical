import java.util.*;
import java.io.*;

public class atcoder_AGC012_A {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        long ans = 0;
        for (int i = n - 2; i >= n * 2 - 1; i--) {
            ans += A[i];
        }
        System.out.println(ans);
    }
}