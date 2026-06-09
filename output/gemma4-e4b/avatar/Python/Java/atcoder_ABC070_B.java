import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class atcoder_ABC070_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String line = scanner.nextLine();
        
        // Parse the space-separated integers into an ArrayList
        String[] parts = line.trim().split("\\s+");
        ArrayList<Integer> A = new ArrayList<>();
        
        for (String part : parts) {
            if (!part.isEmpty()) {
                try {
                    A.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    // Should not happen if input matches Python's expectation
                }
            }
        }
        
        // The Python code assumes at least 4 elements exist.
        if (A.size() < 4) {
            // Handle insufficient input size if necessary, 
            // but proceeding with the logic assuming valid input size >= 4
        }

        // Check the condition: A[1] <= A[2] or A[3] <= A[0]
        int a1 = A.get(1);
        int a2 = A.get(2);
        int a3 = A.get(3);
        int a0 = A.get(0);

        if (a1 <= a2 || a3 <= a0) {
            System.out.println(0);
        } else {
            // Sort A
            Collections.sort(A);
            
            // Print A[2] - A[1]
            int result = A.get(2) - A.get(1);
            System.out.println(result);
        }
        
        scanner.close();
    }
}