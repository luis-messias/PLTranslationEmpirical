import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_583_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N (n is read but unused in the logic)
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading N, if any.
        scanner.nextLine(); 

        // 2. Read the list A
        String line = scanner.nextLine();
        
        // Parse the space-separated integers into an ArrayList
        ArrayList<Integer> a = new ArrayList<>();
        if (!line.trim().isEmpty()) {
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                try {
                    a.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    // Skip non-integer parts if necessary
                }
            }
        }
        
        // Initialization
        int counter = 0;
        int counterTurns = -1;

        // Main loop: while counter < len(a)
        while (counter < a.size()) {
            counterTurns++;

            // Inner loop: for i in range(len(a))
            for (int i = 0; i < a.size(); i++) {
                int element = a.get(i);
                
                // Check condition: a[i] != -1 and a[i] <= counter
                if (element != -1 && element <= counter) {
                    // Action:
                    counter++;
                    a.set(i, -1); // Mark as used
                }
            }
            
            // a.reverse()
            Collections.reverse(a);
        }

        System.out.println(counterTurns);
        scanner.close();
    }
}