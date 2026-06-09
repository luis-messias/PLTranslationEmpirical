import java.util.Scanner;

public class codeforces_306_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and m from a single line of input
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int m = scanner.nextInt();

                int q = n / m;
                int r = n % m;

                int[] a = new int[m];
                
                // Initialize all elements to q
                for (int i = 0; i < m; i++) {
                    a[i] = q;
                }

                // Add 1 to the first r elements
                for (int i = 0; i < r; i++) {
                    a[i] += 1;
                }

                // Print the result
                for (int i = 0; i < m; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}