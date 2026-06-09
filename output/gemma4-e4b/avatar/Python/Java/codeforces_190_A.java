import java.util.Scanner;

public class codeforces_190_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and m from a single line input
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed
            return;
        }
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Block 1: if n < 1
        if (n < 1) {
            if (m < 1) {
                System.out.println(n + " " + m);
                return; // quit()
            } else {
                System.out.println("Impossible");
                return; // quit()
            }
        }
        
        // Block 2: if m > n
        if (m > n) {
            int min = m;
            int max = n + m - 1;
            System.out.println(min + " " + max);
        }
        
        // Block 3: if m <= n
        if (m <= n) {
            int min = n;
            int max = n + m - 1;
            if (m == 0) {
                max = n;
            }
            System.out.println(min + " " + max);
        }
        
        scanner.close();
    }
}