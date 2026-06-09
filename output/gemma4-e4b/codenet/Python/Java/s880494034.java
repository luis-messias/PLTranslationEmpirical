import java.util.Scanner;
import java.util.Arrays;

public class s880494034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (first line, though unused in calculation)
        if (!scanner.hasNextLine()) {
            return;
        }
        String nLine = scanner.nextLine();

        // Read the array elements (second line)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] s = line.split("\\s+");
        
        // Handle case where input might be empty or only whitespace
        if (s.length == 0 || (s.length == 1 && s[0].isEmpty())) {
            return;
        }

        int[] xs = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            xs[i] = Integer.parseInt(s[i]);
        }

        // Initialize minimum cost to a very large value (Long.MAX_VALUE)
        long minCost = Long.MAX_VALUE;

        // Loop i from 1 to 100
        for (int i = 1; i <= 100; i++) {
            long currentCost = 0;
            
            // Calculate sum of squared differences: sum((x - i)^2)
            for (int x : xs) {
                // Calculate difference (x - i)
                long diff = (long)x - i;
                // Add squared difference
                currentCost += diff * diff;
            }

            // Update minimum cost
            if (currentCost < minCost) {
                minCost = currentCost;
            }
        }

        System.out.println(minCost);
        scanner.close();
    }
}