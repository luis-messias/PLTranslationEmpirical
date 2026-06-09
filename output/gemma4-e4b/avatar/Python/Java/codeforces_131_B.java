import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class codeforces_131_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (unused in the logic, but required to consume the first line)
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty
            System.out.println(0);
            return;
        }
        int n = scanner.nextInt();

        // Read the rest of the line/input stream for the numbers
        // Since we don't know how many numbers are on the second line, 
        // we read until the next line break or EOF.
        
        // We assume the remaining input consists of space-separated integers.
        // We read all remaining tokens and process them.
        
        Map<Integer, Long> counts = new HashMap<>();
        
        // Read all remaining tokens as integers
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            counts.put(num, counts.getOrDefault(num, 0L) + 1);
        }
        
        scanner.close();

        long c = 0;

        // Iterate over all unique numbers found in the input
        for (int i : counts.keySet()) {
            long countI = counts.get(i);

            if (i == 0) {
                // Case i = 0: Pairs of zeros (k * (k - 1))
                c += countI * (countI - 1);
            } else {
                // Case i != 0: Check for the complement -i
                if (counts.containsKey(-i)) {
                    long countNegI = counts.get(-i);
                    
                    // We count pairs (i, -i). This counts the pair twice 
                    // (once when processing i, and once when processing -i).
                    c += countI * countNegI;
                }
            }
        }

        // The total count 'c' was double-counted for non-zero pairs, 
        // and the zero pairs calculation is correct. We divide by 2.
        System.out.println