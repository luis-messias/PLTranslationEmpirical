import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_456_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // 2. Read the line containing the matrix data
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");

        // Check if we have enough tokens for N rows
        if (tokens.length == 0) {
            System.out.println("Poor Alex"); // Or handle error appropriately
            return;
        }

        // Determine K (number of columns)
        int k = tokens.length / n;
        
        // If the input structure implies that the number of tokens is not perfectly divisible by N, 
        // the original Python list comprehension would likely fail or behave unexpectedly.
        // We proceed assuming the input is structured correctly for N rows of K elements.

        // 3. Parse the input into a list of lists (matrix m)
        List<List<Integer>> m = new ArrayList<>();
        int tokenIndex = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (tokenIndex < tokens.length) {
                    row.add(Integer.parseInt(tokens[tokenIndex++]));
                } else {
                    // Handle case where input is truncated, though unlikely based on problem context
                    break; 
                }
            }
            m.add(row);
        }

        // 4. Sort the matrix m in reverse order
        // Sorting lists of lists in Java uses lexicographical comparison.
        Collections.sort(m, Collections.reverseOrder());

        // 5. Apply the comparison logic
        if (n == 0) {
            System.out.println("Poor Alex");
            return;
        }
        
        List<Integer> a = m.get(0); // Initialize a to the first row

        // Iterate through the rest of the rows starting from index 1
        for (int i = 1; i < n; i++) {
            List<Integer> current = m.get(i);
            
            // Check if the second element (index 1) of the current row is greater than 
            // the second element of the current best row 'a'.
            // We must ensure both rows have at least 2 elements before accessing index 1.
            if (current.size() > 1 && a.size() > 1 && current.get(1) > a.get(1)) {
                System.out.println("Happy Alex");
                break;
            }
            
            // Update a if the current row is better (or if we haven't found a break condition yet)
            // The Python code updates 'a = i' regardless of the comparison result if the condition fails.
            // Since the sort is reverse, we are looking for the first row that breaks the non-decreasing sequence of the second element.
            // If we are iterating through
