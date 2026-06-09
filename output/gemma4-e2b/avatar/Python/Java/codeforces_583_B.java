import java.util.Scanner;
import java.util.Arrays;

public class codeforces_583_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the array elements (second input line)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        
        // Handle case where input line might be empty or only whitespace
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            // If no array elements are provided, we might stop here or handle error.
            // Assuming valid input based on Python context, we proceed if possible.
            return;
        }

        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                a[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Handle parsing error if necessary, though usually assumed correct in these contexts
                return;
            }
        }

        int current_level = 0; // Unused in the core logic
        int counter = 0;
        int counter_turns = -1;

        // Core logic translation
        while (counter < a.length) {
            counter_turns += 1;
            for (int i = 0; i < a.length; i++) {
                // Check if element is not -1 and its value is less than or equal to the current counter
                if (a[i] != -1 && a[i] <= counter) {
                    counter += 1;
                    a[i] = -1; // Mark as processed
                }
            }
            // Reverse the array
            // In Java, we reverse the array in place
            int start = 0;
            int end = a.length - 1;
            while (start < end) {
                int temp = a[start];
                a[start