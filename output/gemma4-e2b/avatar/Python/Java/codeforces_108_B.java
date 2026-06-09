import java.util.Arrays;
import java.util.Scanner;

public class codeforces_108_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String line = scanner.nextLine();
        
        // Split the input string by whitespace to get the numbers
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length < 2) {
            // If there are fewer than 2 elements, the condition cannot be checked, result is NO.
            System.out.println("NO");
            return;
        }

        // Convert string parts to integers
        Integer[] a = new Integer[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            // Handle case where input contains non-integer values
            return;
        }
        
        // Sort the array (a.sort())
        Arrays.sort(a);
        
        boolean found = false;
        
        // Iterate through the sorted array (for i in range(1, len(a)))
        for (int i = 1; i < a.length; i++) {
            // Check: a[i] != a[i - 1] and a[i]