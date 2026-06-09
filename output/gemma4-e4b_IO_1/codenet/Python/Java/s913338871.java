import java.util.Arrays;
import java.util.Scanner;

public class s913338871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // 2. Read the array elements (a)
        // Consume the rest of the line after N, if any, and then read the array elements.
        // Since the input format is N on line 1, and the array on line 2, 
        // we need to handle the transition.
        
        // We assume the remaining input stream contains the space-separated integers for 'a'.
        
        // Read the entire line containing the array elements
        scanner.nextLine(); // Consume the rest of the line after N
        
        String line = "";
        if (scanner.hasNextLine()) {
            line = scanner.nextLine();
        }
        
        String[] parts = line.trim().split("\\s+");
        
        int[] a = new int[0];
        if (parts.length > 0 && parts[0].isEmpty() == false) {
            a = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }
        }

        // 3. Sort a
        Arrays.sort(a);

        // 4. Calculate the sum of elements at indices N, N+2, N+4, ...
        long sum = 0;
        
        // Check if N is a valid starting index
        if (N >= 0 && N < a.length) {
            for (int i = N;
