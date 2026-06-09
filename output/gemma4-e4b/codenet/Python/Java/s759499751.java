import java.util.Scanner;

public class s759499751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Read string A
        String a = scanner.next();

        // Initialize prefix sum array C
        int[] c = new int[n];

        // Calculate C array
        // c[0] remains 0 (default initialization)
        for (int i = 1; i < n; i++) {
            char charI = a.charAt(i);
            char charIMinus1 = a.charAt(i - 1);

            if (charI == 'C' && charIMinus1 == 'A') {
                c[i] = c[i - 1] + 1;
            } else {
                c[i] = c[i - 1];
            }
        }

        // Process K queries
        for (int w = 0; w < k; w++) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            // Calculate c[r-1] - c[l-1]
            // Since l and r are 1-based, they map to indices l-1 and r-1.
            // We must ensure indices are within bounds [0, n-1].
            
            // The problem assumes valid 1-based indices l and r such that 1 <= l <= r <= n.
            // c[r-1] is the count up to index r-1.
            // c[l-1] is the count up to index l-1.
            
            // If l=1, c[l-1] = c[0] = 0.
            int result = c[r - 1] - c[l - 1];
            System.out.println(result);
        }

        scanner.close();
    }
}