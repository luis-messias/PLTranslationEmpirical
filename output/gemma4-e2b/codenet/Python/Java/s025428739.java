import java.util.Scanner;

public class s025428739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A and B from input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            // Calculate the three values
            int sum = A + B;
            int diff = A - B;
            int prod = A * B;

            // Find the maximum of the three values
            int maxVal = Math.max(sum, Math.max(diff, prod));

            // Print the result
            System.out.println(maxVal);
        }
        
        scanner.close();
    }
}