import java.util.Scanner;

public class s893778513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line (n), which is unused in the logic
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // Read the second line containing the list elements
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            if (line.trim().isEmpty()) {
                // Handle case where the list input is empty
                return;
            }

            // Parse the space-separated integers
            String[] parts = line.split("\\s+");
            int[] l = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                l[i] = Integer.parseInt(parts[i]);
            }

            // Calculate sum (s)
            long s = 0;
            for (int x : l) {
                s += x;
            }

            // Calculate max (b)
            int b = l[0];
            for (int i = 1; i < l.length; i++) {
                if (l[i] > b) {
                    b = l[i];
                }
            }
            
            // Check the condition: b < s - b
            // We cast b to long for safe comparison with s.
            if ((long)b < s - (long)b) {