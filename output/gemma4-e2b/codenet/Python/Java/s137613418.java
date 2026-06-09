import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

public class s137613418 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (load())
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed, though usually guaranteed in CP environments
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after n

        // Read A (load_list())
        if (!scanner.hasNextLine()) {
            // No list provided
            return;
        }
        String lineA = scanner.nextLine();
        
        // Parse the list A
        // load_list splits by space and converts to integers
        String[] parts = lineA.trim().split("\\s+");
        
        // Filter out empty strings that might result from splitting
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            // If the line was empty, A is empty
            // We proceed assuming A is empty if input line was effectively empty
        }
        
        // Convert parts to integers
        int[] A = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                A[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Handle potential parsing errors if input contains non-integer tokens
                // Depending on strictness, we might stop or handle error. Assuming valid integer input based on Python context.
                // For robustness, we might skip or throw, but here we rely on the structure.
                // If we strictly follow the Python logic, we assume successful parsing.
            }
        }

        // Calculate len(set(A))
        Set<Integer> setA = new HashSet<>();
        for (int val : A) {
            setA.add(val);
        }
        
        int uniqueCount = setA.size();

        // Check condition: n == len(set(A))
        if (n == uniqueCount) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}