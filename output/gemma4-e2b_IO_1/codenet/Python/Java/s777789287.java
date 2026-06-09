import java.util.Scanner;
import java.util.Arrays;

public class s777789287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            a[i] = scanner.nextInt();
        }

        // Sort a in reverse (descending) order
        Arrays.sort(a);
        // Reverse the sorted array to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }

        // Calculate sum
        long sum = 0;
        for (int x : a) {
            sum += x;
        }

        // Calculate s = sum(a) / (4*m)
        // Use double for floating point division
        double s = (double) sum / (4.0 * m);

        // Check the condition: a[m-1] >= s
        // We must ensure m is valid for indexing a[m-1] (1 <= m <= n)
        if (m > 0 && m <= n) {
            if (a[m - 1] >= s) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
