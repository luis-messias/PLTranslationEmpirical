import java.util.Scanner;

public class atcoder_ABC127_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read r, D, x from standard input (assuming they are space-separated)
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int rInt = scanner.nextInt();
        int DInt = scanner.nextInt();
        int xInt = scanner.nextInt();
        
        scanner.close();

        // Use double for calculations to maintain precision
        double r = rInt;
        double D = DInt;
        double x = xInt;

        // Calculate the common term T = D / (1 - r)
        // Assuming r != 1 based on the formula structure.
        double T = D / (1.0 - r);

        // Loop from i = 2 to i = 11 (range(2, 12))
        for (int i = 2; i < 12; i++) {
            // Calculate P = r^(i - 1)
            double P = Math.pow(r, i - 1);
            
            // Calculate the expression: P * (x + T) - T
            double resultDouble = P * (x + T) - T;
            
            // Print the integer part of the result (matching Python's int() cast)
            System.out.println((int) resultDouble);
        }
    }
}