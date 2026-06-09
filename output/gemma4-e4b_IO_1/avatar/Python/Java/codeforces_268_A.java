import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_268_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        // Read N
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after N

        // q stores the list of string arrays
        List<String[]> q = new ArrayList<>();
        
        // Read N lines into q
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] a;
            
            // Handle splitting. If the line is empty or only whitespace, the array is empty.
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) {
                a = new String[0];
            } else {
                // Split by one or more whitespace characters
                a = trimmedLine.split("\\s+");
            }
            q.add(a);
        }
        
        long count = 0;
        
        // Iterate through pairs (j, k)
        for (String[] j : q) {
            for (String[] k : q) {
                
                // Check if j and k are the same object reference
                if (k == j) {
                    continue;
                }
                
                // Check if j[0] exists (j must not be empty)
                boolean j_has_first = j.length > 0;
                
                // Check if k[len(k) - 1] exists (k must not be empty)
                boolean k_has_last = k.length > 0;
                
                if
