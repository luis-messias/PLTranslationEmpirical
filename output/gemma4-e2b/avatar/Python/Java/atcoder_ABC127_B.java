import java.util.Scanner;

public class atcoder_ABC127_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read r, D, x from input
        if (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int D = scanner.nextInt();
            int x = scanner.nextInt();

            // Loop from i = 2 to 11
            for (int i = 2; i <= 11; i++) {
                // Calculate the expression. Use double for intermediate calculations 
                // to handle division accurately, as implied by the formula structure.
                double r_d = r;
                double D_d = D;
                double x_d = x;
                
                double term = Math.pow(r_d, i - 1) * (x_d + D_d / (1.0 - r_d)) - D_d / (1.0 - r_d);
                
                // Print the integer part, matching Python's int() cast
                System.out.println((int) term);
            }
        }
        scanner.close();
    }
}