import java.util.Scanner;
import java.util.Arrays;

public class codeforces_356_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine().trim();
        if (line1.isEmpty()) return;
        
        String[] parts = line1.split("\\s+");
        if (parts.length < 2) return;
        
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        // Initialization
        int[] out = new int[n];
        // comp[i] = i + 2
        int[] comp = new int[n];
        for (int i = 0; i < n; i++) {
            comp[i] = i + 2;
        }

        // Process M queries
        for (int k = 0; k < m; k++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                k--; // Retry this iteration if line was empty, though usually input is guaranteed
                continue;
            }
            
            String[] queryParts = line.split("\\s+");
            if (queryParts.length < 3) continue;
            
            int l = Integer.parseInt(queryParts[0]);
            int r = Integer.parseInt(queryParts[1]);
            int x = Integer.parseInt(queryParts[2]);

            int t = l;
            while (t <= r) {
                int index = t - 1;
                
                // next_val = comp[t - 1]
                int next_val = comp[index];
                
                // if out[t - 1] == 0 and t != x:
                if (out[index] == 0 && t != x) {
                    out[index] = x;
                }
                
                // comp[t - 1] = r + 1 if t >= x else x
                if (t >= x) {
                    comp[index] = r + 1;
                } else {
                    comp[index] = x;
                }
                
                // t = next_val
                t = next_val;
            }
        }

        // Print out
        System.out.println(Arrays.toString(out));
        
        scanner.close();
    }
}