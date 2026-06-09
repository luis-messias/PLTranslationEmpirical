import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class s534639230 {

    static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N (not strictly used in the calculation logic, but read for completeness)
        String line1 = br.readLine();
        if (line1 == null) return;
        // N is read but ignored based on the Python logic structure
        // int N = Integer.parseInt(line1.trim()); 

        // Read D
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer st = new StringTokenizer(line2);
        
        // D is the list of numbers
        int[] D = new int[st.countTokens()];
        for (int i = 0; i < D.length; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        long mod = 998244353;

        // 1. Calculate counts (Counter equivalent)
        Map<Integer, Long> cnt = new HashMap<>();
        int maxD = 0;
        for (int x : D) {
            cnt.put(x, cnt.getOrDefault(x, 0L) + 1);
            if (x > maxD) {
                maxD = x;
            }
        }

        // 2. Check initial conditions
        if (D.length == 0) {
            System.out.println(1); // Or handle as error, assuming D is non-empty based on Python structure
            return;
        }
        
        if (D[0] != 0) {
            System.out.println(0);
            return;
        }

        if (cnt.getOrDefault(0, 0L) > 1) {
            System.out.println(0);
            return;
        }

        // 3. Calculate result
        long res = 1;

        // Iterate i from 1 to max(D)
        for (int i = 1; i <= maxD; i++) {
            long count_i_minus_1 = cnt.getOrDefault(i - 1, 0L);
            
            if (count_i_minus_1 == 1) {
                continue;
            }
            
            long count_i = cnt.getOrDefault(i, 0L);
            
            // res *= cnt[i-1]**cnt[i] % mod
            long