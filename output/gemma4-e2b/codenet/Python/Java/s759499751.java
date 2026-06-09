import java.util.Scanner;

public class s759499751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Read string a
        if (!scanner.hasNext()) return;
        String a = scanner.next();

        // Initialize prefix sum array c
        int[] c = new int[n];

        // Calculate prefix sums
        for (int i = 1; i < n; i++) {
            // Check transition a[i-1] -> a[i]
            if (a.charAt(i) == 'C' && a.charAt(i - 1) == 'A') {
                c[i] = c[i - 1] + 1;
            } else {
                c[i] = c[i - 1];
            }
        }

        // Process k queries
        for (int w = 0; w < k; w++) {
            if (!scanner.hasNextInt()) break;
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            
            // Calculate result: c[r-1] - c[l-1]
            // Since the prefix sum calculation uses 1-based indexing logic 
            // (c[i] stores the sum up to index i), 
            // the range sum [l, r] corresponds to c[r-1] - c[l-1].
            System.out.println(c[r - 1] - c[l - 1]);
        }
        
        scanner.close();
    }
}