import java.util.Scanner;
import java.util.Arrays;

public class codeforces_673_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (although n is unused in the logic, it must be consumed)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading n
        scanner.nextLine();

        // Read the line containing space-separated array elements
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Handle empty input line
        if (line.trim().isEmpty()) {
            return;
        }

        // Parse the line into an array of integers
        String[] tokens = line.trim().split("\\s+");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++)