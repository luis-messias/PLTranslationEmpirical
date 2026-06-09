import java.util.Scanner;

public class s001486412 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        int n = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Calculate the sum (below)
        double below = 0.0;
        for (int i = 0; i < n; i++) {
            // Use 1.0 to ensure floating-point division
            below += 1.0 / a[i];
        }

        // Print 1/below
        System.out.println(1.0 / below);
        
        scanner.close();
    }
}