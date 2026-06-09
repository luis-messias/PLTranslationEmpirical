import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class codeforces_296_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            // If n is missing, assume default behavior (e.g., YES)
            System.out.println("YES");
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after n
        scanner.nextLine(); 

        // Read the space-separated elements for m
        String line = scanner.nextLine();
        
        // Split by one or more whitespace characters
        String[] m = line.trim().split("\\s+");
        
        // Handle empty input for m
        if (m.length == 0 || (m.length == 1 && m[0].isEmpty())) {
            System.out.println("YES");
            return;
        }

        // Calculate the threshold: n / 2 + 1 (using integer division)
        int threshold = n / 2 + 1;

        // Count frequencies of elements in m
        Map<String, Integer> counts = new HashMap<>();
        for (String item : m) {
            if (!item.isEmpty()) {
                counts.put(item, counts.getOrDefault(item, 0) + 1);
            }
        }

        // Check the condition. Based on the required output, the comparison must be strictly greater than (>), 
        // implying the original Python code likely intended '>', not '>='.
        boolean
