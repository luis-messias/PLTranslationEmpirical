import java.util.Scanner;

public class s167793578 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and M
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            // Calculate a = N * (N - 1) / 2
            // Use long for intermediate calculation to prevent potential overflow, although for typical constraints, int might suffice.
            long a = (long)N * (N - 1) / 2;
            long b = (long)M * (M - 1) / 2;
            
            // Print a + b
            System.out.println(a + b);
        }
        
        scanner.close();
    }
}