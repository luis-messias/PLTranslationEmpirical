import java.util.Scanner;

public class atcoder_AGC002_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read two integers a and b
        if (!scanner.hasNextInt()) {
            // Handle case where no input is provided, though typically competitive programming assumes valid input
            return;
        }
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        scanner.close();

        if (a > 0) {
            System.out.println("Positive");
        } else if (a <= 0 && b >= 0) {
            System.out.println("Zero");
        } else {
            // The original Python logic uses (a + b) % 2 == 0 for the 'Negative' case
            if ((a + b) % 2 == 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Positive");
            }
        }
    }
}