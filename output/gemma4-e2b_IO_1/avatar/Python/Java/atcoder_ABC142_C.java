import java.util.Scanner;

public class atcoder_ABC142_C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the data you want to process:");
        // In a real scenario, you would read the data from a file or another source.
        // For this example, we'll just read a line of input.
        String line = scanner.nextLine();

        System.out.println("You entered: " + line);

        // --- Placeholder for actual data processing ---
        // Since the input is just a string, we'll demonstrate a simple operation.
        // If the input was expected to be numbers, you would parse it here.

        try {
            // Example: If the input was a comma-separated list of numbers
            String[] numbers = line.split(",");
            if (numbers.length > 0) {
                System.out.println("\nProcessing the numbers:");
                for (String numStr : numbers) {
                    try {
                        int number = Integer.parseInt(numStr.trim());
                        System.out.println("Processed number: " + (number * 2)); // Example operation
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping non-numeric input: " + numStr.trim());
                    }
                }
            } else {
                System.out.println("\nNo comma-separated numbers found in the input.");
            }
        } catch (Exception e) {
            System.out.println("\nAn error occurred during processing: " + e.getMessage());
        }

        scanner.close();
    }
}
