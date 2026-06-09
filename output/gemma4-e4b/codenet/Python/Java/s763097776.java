import java.util.Arrays;
import java.util.Scanner;

public class s763097776 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read P
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        // Create p_copy (original array)
        int[] p_copy = Arrays.copyOf(p, n);

        // Sort p
        Arrays.sort(p);

        // Count differences
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != p_copy[i]) {
                count++;
            }
        }

        // Check condition
        if (count == 0 || count == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}