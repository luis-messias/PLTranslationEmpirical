import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_456_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading N
        scanner.nextLine(); 

        // Read the matrix M
        List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                // Handle potential empty lines if input format is inconsistent
                i--; 
                continue;
            }
            
            // Parse the space-separated integers into a list
            List<Integer> row = java.util.Arrays.stream(line.trim().split("\\s+"))
                                        .filter(s -> !s.isEmpty())
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
            m.add(row);
        }

        // Sort M in reverse order. 
        // Assuming standard sorting criteria (e.g., based on the first element) 
        // to replicate Python's list sorting behavior for rows.
        // We sort by the first element (index 0) in descending order.
        m.sort(Comparator.comparingInt((List<Integer> row) -> row.get(0)).reversed());

        if (m.isEmpty()) {
            // Should not happen if N > 0, but handles edge case
            System.out.println("Poor Alex");
            return;
        }

        // a = m[0]
        List<Integer> a = m.get(0);
        boolean happyAlex = false;

        // Iterate through m[1:]
        for (int i = 1; i < m.size(); i++) {
            List<Integer> current = m.get(i);
            
            // Check the condition: if i[1] > a[1]
            // We must ensure both lists have at least 2 elements before accessing index 1.
            if (a.size() > 1 && current.size() > 1) {
                if (current.get(1) > a.get(1)) {
                    System.out.println("Happy Alex");
                    happyAlex = true;
                    break;
                }
            } else {
                // If either row is too short, we assume the condition fails or handle based on problem constraints.
                // Since the Python code assumes index 1 exists, we proceed assuming valid input structure.
            }
            
            // Update a = i
            a = current;
        }

        // If the loop completed without breaking
        if (!happyAlex) {
            System.out.println("Poor Alex");
        }
        
        scanner.close();
    }
}
