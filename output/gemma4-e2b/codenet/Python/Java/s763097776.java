import java.util.Scanner;
import java.util.Arrays;

public class s763097776 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the array p
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            p[i] = scanner.nextInt();
        }

        // p_copy = p[:]
        int[] p_copy = Arrays.copyOf(p, n);

        // p.sort()
        Arrays.sort(p);

        // Count mismatches
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != p_copy[i]) {
                count++;
            }
        }

        // Output result
        if (count == 0 || count == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}