import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class atcoder_ABC174_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read k
        String line = br.readLine();
        if (line == null) return;
        long k = Long.parseLong(line.trim());

        long t = 0;
        boolean found = false;

        for (long i = 1; i <= k; i++) {
            // t = (t % k) * 10 + 7
            // Since k can be large, we use long for intermediate calculations, although the Python logic implies standard integer arithmetic.
            // Given the context of competitive programming constraints, k is likely within standard integer limits, but t might grow.
            // Since the Python code uses standard integer operations, we stick to long for safety if k is large, though the result of the modulo operation will be small.
            
            // t % k
            long remainder = t % k;
            
            // t = remainder * 10 + 7
            t = remainder * 10 + 7;

            // if t % k == 0
            if (t % k == 0) {
                System.out.println(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
