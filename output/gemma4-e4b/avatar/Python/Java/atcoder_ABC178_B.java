import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC178_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the four integers a, b, c, d from standard input.
        // Using long to prevent potential overflow during multiplication.
        if (!scanner.hasNextLong()) {
            // Handle case where input might be missing or malformed
            return;
        }
        
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();
        
        scanner.close();
        
        // Calculate the four products
        long prod1 = a * c;
        long prod2 = b * d;
        long prod3 = a * d;
        long prod4 = b * c;
        
        // Find the maximum of the four products
        long result = Math.max(prod1, Math.max(prod2, Math.max(prod3, prod4)));
        
        System.out.println(result);
    }
}