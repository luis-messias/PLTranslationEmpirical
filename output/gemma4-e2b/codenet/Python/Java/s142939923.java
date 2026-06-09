import java.util.Scanner;

public class s142939923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a and b
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // Calculate A + B
            int sum = a + b;
            // Calculate A - B
            int difference = a - b;
            // Calculate A * B
            int product = a * b;

            // Find the maximum of the three results
            int maxVal = Math.max(sum, Math.max(difference, product));

            System.out.println(maxVal);
        }
    }
}