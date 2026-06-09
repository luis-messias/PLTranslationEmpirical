import java.util.Scanner;

public class s208095748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A, B, C from standard input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            
            if (B < C) {
                System.out.println(0);
            } else if ((long)A * C < B) {
                System.out.println(C);
            } else {
                // Integer division in Java performs floor division for positive numbers,
                // matching Python's // operator behavior in typical scenarios.
                // Assuming A is non-zero based on the original Python logic.
                if (A != 0) {
                    System.out.println(B / A);
                } else {
                    // Handle division by zero if necessary, though the original Python would also error.
                    // For a direct translation, we assume valid input where A != 0.
                    // If we must print something, we might print an error or specific value.
                    // Sticking to the direct translation assuming valid input:
                    System.out.println(B / A); 
                }
            }
        }
        scanner.close();
    }
}