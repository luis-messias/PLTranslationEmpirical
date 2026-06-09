import java.util.Scanner;
import java.lang.Math;

public class codeforces_242_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read initial l and r
        if (!scanner.hasNextInt()) {
            return;
        }
        int l = scanner.nextInt();
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int r = scanner.nextInt();

        int id = 0;

        // Loop runs for i = 1 to n-1
        for (int i = 1; i < n; i++) {
            // Read li and ri
            if (!scanner.hasNextInt()) {
                break;
            }
            int li = scanner.nextInt();
            
            if (!scanner.hasNextInt()) {
                break;
            }
            int ri = scanner.nextInt();

            // Conditional logic
            if (li <= l && r <= ri) {
                id = i;
            } else if (li < l || r < ri) {
                id = n;
            }

            // Update range
            l = Math.min(l, li);
            r = Math.max(r, ri);
        }

        // Output result
        if (id == n) {
            System.out.println(-1);
        } else {
            System.out.println(id + 1);
        }
        
        scanner.close();
    }
}