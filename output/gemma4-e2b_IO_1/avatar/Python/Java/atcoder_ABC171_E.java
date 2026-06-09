import java.util.Scanner;

public class atcoder_ABC171_E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input line
        String line = scanner.nextLine();

        // Split the line by spaces to get the numbers
        String[] parts = line.trim().split("\\s+");

        // Process the numbers (example: printing them)
        System.out.println("Input numbers: " + parts);

        // You can add your specific processing logic here.
        // For example, if you want to calculate the sum:
        /*
        long sum = 0;
        for (String part : parts) {
            try {
                sum += Long.parseLong(part);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + part);
            }
        }
        System.out.println("Sum of numbers: " + sum);
        */
    }
}
