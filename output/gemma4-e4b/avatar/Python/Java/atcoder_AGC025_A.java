import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class atcoder_AGC025_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input n
        String n = scanner.nextLine();
        
        // Define list a
        List<String> a = Arrays.asList("10", "100", "1000", "10000", "100000");
        
        // Calculate new: sum of integer values of characters in n
        int newSum = 0;
        for (char c : n.toCharArray()) {
            // Character.getNumericValue converts a character digit ('1', '2', etc.) to its integer value (1, 2, etc.)
            newSum += Character.getNumericValue(c);
        }
        
        // Check if n is in a
        boolean found = a.contains(n);
        
        // Print result
        if (found) {
            System.out.println(10);
        } else {
            System.out.println(newSum);
        }
        
        scanner.close();
    }
}