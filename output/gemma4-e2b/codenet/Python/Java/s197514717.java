import java.util.Scanner;
import java.lang.Math;

public class s197514717 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the space-separated integers A, B, C
        // The input is expected to be on a single line, e.g., "1 2 3"
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            
            // Calculate the three expressions
            int val1 = 10 * A + B + C;
            int val2 = 10 * B + C + A;
            int val3 = 10 * C + A + B;
            
            // Find the maximum of the three values
            int result = Math.max(val1, Math.max(val2, val3));
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}