import java.util.Scanner;
import java.util.Arrays;

public class codeforces_356_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize out array (size n)
        int[] out = new int[n];
        // Initialize comp array (size n)
        int[] comp = new int[n];

        // Initialize comp[i] = i + 2
        for (int i = 0; i < n; i++) {
            comp[i] = i + 2;
        }

        // Process m queries
        for (int k = 0; k < m; k++) {
            if (!scanner.hasNextInt()) return;
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();

            int t = l;
            
            while (t <= r) {
                // t is 1-based index, array access is t - 1
                int index = t - 1;
                
                // 1. Store next jump value
                int nextVal = comp[index];
                
                // 2. Update out array
                if (out[index] == 0 && t != x) {
                    out[index] = x;
                }
                
                // 3. Update comp array
                int newValue;
                if (t >= x) {
                    newValue = r + 1;
                } else {
                    newValue = x;
                }
                comp[index] = newValue;
                
                // 4. Advance t
                t = nextVal;
            }
        }

        // Print the contents of the out array
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(out[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

        scanner.close();
    }
}