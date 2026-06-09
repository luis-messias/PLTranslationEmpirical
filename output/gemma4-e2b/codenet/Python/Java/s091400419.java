import java.util.Scanner;

public class s091400419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a and b from input
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();

                // Calculate the three values
                int sum = a + b;
                int diff = a - b;
                int prod = a * b;

                // Find the maximum
                int maxVal = Math.max(sum, Math.max(diff, prod));

                // Print the result
                System.out.println(maxVal);
            }
        }
        scanner.close();
    }
}