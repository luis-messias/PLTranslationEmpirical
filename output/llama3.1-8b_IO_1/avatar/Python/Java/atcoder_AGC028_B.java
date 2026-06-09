import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_AGC028_B {
    static final int MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(input[i]);
        }
        int M = (int)1e6;
        long[][] fact = new long[(int)1e3][(int)1e3];
        for(int i=0; i<fact.length; i++) {
            for(int j=0; j<fact[0].length; j++) {
                fact[i][j] = 1;
            }
        }
        for(int n=1; n<fact[0].length; n++){
            for(int i=0; i<fact.length; i++){
                fact[i][n] = (int)((long)fact[i][n-1]*fact[i][n-1]%MOD);
            }
        }
        long[] inv = new long[N];
        for(int i=0; i<N; i++) {
            inv[i] = pow(i+1, MOD-2, MOD);
        }
        for(int i=1; i<inv.length; i++){
            inv[i] += inv[i-1];
            inv[i] %= MOD;
        }
        long[] temp = new long[N];
        for(int j=0; j<N; j++) {
            temp[j] = (inv[j] + inv[inv.length-1-j] - 1) % MOD;
        }
        long ans = 0;
        for(int i=0; i<A.length; i++){
            ans += A[i]*temp[i]%MOD;
            ans %= MOD;
        }
        ans *= fact[fact.length][fact[0].length];
        ans %= MOD;
        System.out.println(ans);
    }

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    static String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static long pow(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int randomPosition = (int)(Math.random()*n);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }
    }

    static void sort(long[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int randomPosition = (int)(Math.random()*n);
            long temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }
    }
}
