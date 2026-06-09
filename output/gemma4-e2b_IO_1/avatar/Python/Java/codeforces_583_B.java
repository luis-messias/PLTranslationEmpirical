import java.util.Scanner;
import java.util.Arrays;

public class codeforces_583_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input) - Although n is read, it is not used in the core logic based on the Python snippet structure.
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after n

        // Read the array elements (second input line)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            return;
        }

        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                a[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Should not happen with valid input format
                return;
            }
        }

        int counter = 0;
        int counter_turns = -1;

        // Core logic translation
        while (counter < a.length) {
            counter_turns += 1;
            
            // Phase 1: Find elements to mark and update counter
            for (int i = 0; i < a.length; i++) {
                // Check if element is not -1 and its value is less than or equal to the current counter
                if (a[i] != -1 && a[i] <= counter) {
                    counter += 1;
                    a[i] = -1; // Mark as processed
                }
            }
            
            // Phase 2: Reverse the array (a.reverse() in Python)
            // We need to reverse the array 'a' in place.
            int start = 0;
            int end = a.length - 1;
            while (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }

        System.out.println(counter_turns);
        scanner.close();
    }
}
