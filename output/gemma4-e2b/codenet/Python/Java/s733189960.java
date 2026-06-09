import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class s733189960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading n

        HashMap<String, Integer> sdic = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            
            // Sort the characters
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            
            // Form the sorted string
            String s = new String(chars);

            // Count the frequency
            sdic.put(s, sdic.getOrDefault(s, 0) + 1);
        }

        long ans = 0;
        for (int v : sdic.values()) {
            // Calculate v * (v - 1) / 2
            ans += (long) v * (v - 1) / 2;
        }

        System.out.println(ans);
        scanner.close();
    }
}