import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC012_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the line containing A
        if (!scanner.hasNextLine()) return;
        String lineA = scanner.nextLine();
        
        // Parse A
        String[] parts = lineA.trim().split("\\s+");
        
        if (parts.length == 0) {
            System.out.println(0);
            scanner.close();
            return;
        }
        
        int[] A = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                A[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Should not happen with valid input, but good practice
                return; 
            }
        }

        // Sort A
