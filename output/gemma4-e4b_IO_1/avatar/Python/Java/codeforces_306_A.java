import java.util.Scanner;
import java.util.Arrays;

public class codeforces_306_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        // Handle potential empty input or incorrect format gracefully, though assuming valid input based on context
        if (parts.length < 2) return; 

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int q = n / m;
        int r = n % m;

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = q;
        }

        // Correction: The remainder 'r' must be added to the last 'r' elements (indices m-r to m-1)
        for (int i = m - r; i < m; i++) {
            a[i]++;
        }

        for (int i = 0; i < m; i++) {
            System.out.print(a[i] + (i == m - 1 ? "" : " "));
        }
        System.out.println();
    }
}
