import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC070_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Split the line by whitespace and convert to integers
            String[] parts = line.split("\\s+");
            int[] A = new int[parts.length];
            
            try {
                for (int i = 0; i < parts.length; i++) {
                    A[i] = Integer.parseInt(parts[i]);
                }

                // Check the condition: A[1] <= A[2] or A[3] <= A[0]
                if (A.length >= 4 && (A[1] <= A[2] || A[3] <= A[0])) {
                    System.out.println(0);
                } else {
                    // Sort the array
                    Arrays.sort(A);
                    // Calculate and print A[2] - A[1]
                    System.out.println(A[2] - A[1]);
                }
            } catch (NumberFormatException e) {
                // Handle case where input parts are not valid integers, though usually assumed valid in these contexts
                // We skip processing if parsing fails.
            }
        }
        scanner.close();
    }
}