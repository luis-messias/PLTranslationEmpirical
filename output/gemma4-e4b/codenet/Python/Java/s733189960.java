import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class s733189960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading N

        // Map to store counts of sorted strings
        Map<String, Integer> sdic = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String inputStr = scanner.nextLine().trim();
            
            // Convert to char array
            char[] chars = inputStr.toCharArray();
            
            // Sort the characters
            Arrays.sort(chars);
            
            // Convert back to string
            String sortedStr = new String(chars);
            
            // Update count
            sdic.put(sortedStr, sdic.getOrDefault(sortedStr, 0) + 1);
        }
        
        scanner.close();

        // Calculate the answer: sum of v*(v-1)/2 for all counts v
        long ans = 0;
        for (int count : sdic.values()) {
            // Use long for calculation to prevent overflow
            ans += (long)count * (count - 1) / 2;
        }
        
        System.out.println(ans);
    }
}