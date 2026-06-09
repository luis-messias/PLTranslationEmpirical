import java.util.Scanner;

public class s423256012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read A and B from input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            // Check if (A + B) is odd
            if ((A + B) % 2 != 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                // If even, print the result of integer division
                System.out.println((A + B) / 2);
            }
        }
        scanner.close();
    }
}