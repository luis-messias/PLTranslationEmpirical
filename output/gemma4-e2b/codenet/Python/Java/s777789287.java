import java.util.Scanner;
import java.util.Arrays;

public class s777789287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read the array a from the second line
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            a[i] = scanner.nextInt();
        }

        // Sort a in reverse (descending) order
        Arrays.sort(a);
        // Reverse the sorted array to get descending order (equivalent to a.sort(reverse=True))
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
        // We must ensure m-1 is a valid index (m must be <= n)
        if (m > 0 && m <= n) {
            if (a[m - 1] >= s) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            // Handle case where m is out of bounds if necessary, though typically constraints ensure validity.
            // Based strictly on the Python logic, we assume m is valid for indexing a[m-1].
            // If m is invalid, we might skip printing or handle an error, but we follow the direct translation.
            // Since the Python code assumes valid indexing, we proceed with the check.
            if (m > 0 && m <= n) {
                 if (a[m - 1] >= s) {
                    System.out.