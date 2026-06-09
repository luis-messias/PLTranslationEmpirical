import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class s662673721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read n
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;
        }
        long n = Long.parseLong(line.trim());

        // Initialize ans to a very large value (10^18 is used in Python)
        long ans = Long.MAX_VALUE;

        // Iterate up to sqrt(n)
        // The loop condition i * i <= n is equivalent to i <= sqrt(n) and avoids floating point issues
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                long j = n / i;
                // Calculate i + j - 2 and update ans
                ans = Math.min(ans, i + j - 2);
            }
        }

        System.out.println(ans);
    }
}