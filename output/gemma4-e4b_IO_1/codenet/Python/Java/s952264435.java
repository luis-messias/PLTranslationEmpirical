import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s952264435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and M (Line 1)
        String line1 = br.readLine();
        if (line1 == null) return;
        
        StringTokenizer st1 = new StringTokenizer(line1);
        
        // N is the first token
        int N = Integer.parseInt(st1.nextToken());
        // M is the second token (M is unused, but read for completeness)
        int M = Integer.parseInt(st1.nextToken());

        // Read A elements (Line 2)
        String line2 = br.readLine();
        if (line2 == null) {
            // If no second line, A_sum is 0 (assuming A is empty)
            System.out.println(N);
            return;
        }

        StringTokenizer st2 = new StringTokenizer(line2);
        
        long A_sum = 0;
        while (st2.hasMoreTokens()) {
            try {
                int a = Integer.parseInt(st2.nextToken());
                A_sum += a;
            } catch (NumberFormatException e) {
                // Skip non-integer tokens if any
            }
        }

        // Calculate N - A_sum
        long result = (long) N - A_sum;

        // Print the result based on the condition
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }
}
