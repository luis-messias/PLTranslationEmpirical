import java.util.Scanner;

public class s031917494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the integer input
        if (scanner.hasNextInt()) {
            int inputNum = scanner.nextInt();
            
            // Calculate the absolute difference
            int count = Math.abs(inputNum - 25);
            
            // Repeat the string " Eve" 'count' times
            // Note: String.repeat() requires Java 11 or later.
            String repeatedString = " Eve".repeat(count);
            
            // Print the final concatenated string
            System.out.println("Christmas" + repeatedString);
        }
        
        scanner.close();
    }
}