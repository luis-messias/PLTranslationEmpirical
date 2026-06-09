import java.util.Scanner;

public class codeforces_30_A {

    public static String task4(int A, int B, int n) {
        for (int X = -1000; X <= 1000; X++) {
            // Calculate A * (X^n). Use long to prevent potential overflow during exponentiation.
            // Math.pow returns a double, so we cast the result to long.
            long power = (long) Math.pow(X, n);
            long result = (long) A * power;

            if (result == B) {
                return String.valueOf(X);
            }
        }
        return "No solution";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line containing A, B, and n
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // Split by one or more whitespace characters
            
            if (parts.length == 3) {
                try {
                    int A = Integer.parseInt(parts[0]);
                    int B = Integer.parseInt(parts[1]);
                    int n = Integer.parseInt(parts[2]);
                    
                    System.out.println(task4(A, B, n));
                } catch (NumberFormatException e) {
                    // Handle potential parsing errors if input is malformed
                }
            }
        }
        scanner.close();
    }
}