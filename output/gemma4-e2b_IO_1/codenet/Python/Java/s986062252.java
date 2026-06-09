import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s986062252 {

    // GCD function
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM function
    static long lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        // Use long for intermediate product to prevent overflow, although inputs are ints
        return Math.abs((long) a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and m from the first line
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);
        
        if (!st.hasMoreTokens()) return;
        int n = Integer.parseInt(st.nextToken());
        
        if (!st.hasMoreTokens()) return;
        int m = Integer.parseInt(st.nextToken());

        // Read s (line 2)
        String s = br.readLine();

        // Read t (line 3)
        String t = br.readLine();

        // Calculate GCD and LCM
        int aa = gcd(n, m);
        long bb = lcm(n, m);
        // cc = aa / bb; // This is 0 unless n=m=0, so we don't strictly need it for the logic below.

        // The Python code uses indices derived from n/aa and m/aa.
        // The loop runs for i in range(aa).
        
        // Check if s and t are long enough for the indices.
        // The indices are n/aa*i and m/aa*i.
        
        // Since the Python code uses s[index] and t[index], we assume s and t are long enough.
        // The maximum index accessed is when i = aa - 1:
        // s[n/aa * (aa - 1)] and t[m/aa * (aa - 1)]
        // Since n/aa and m/aa are integers, the indices are based on the structure of the comparison.

        // The Python code uses n//aa*i and m//aa*i.
        
        for (int i = 0; i < aa; i++) {
            int sIndex = (n / aa) * i;
            int tIndex = (m / aa) * i;
            
            // Check bounds just in case, although the Python code implies valid indices exist.
            if (sIndex >= s.length() || tIndex >= t.length()) {
                // This case implies the input strings are too short for the required comparison structure.
                System.out.println(-1);
                return;
            }

            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                System.out.println(-1);
                return;
            }
        }

        // If the loop completes without finding a mismatch
        System.out.println(bb);
    }
}
