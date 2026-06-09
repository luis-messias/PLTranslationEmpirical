import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class atcoder_ABC120_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String s = scanner.nextLine();
        scanner.close();

        // Check if all characters are the same
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        if (uniqueChars.size() == 1) {
            System.out.println(0);
            return;
        }

        // Count character frequencies
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Find the minimum frequency
        int minFrequency = Integer.MAX_VALUE;
        for (int count : counts.values()) {
            if (count < minFrequency) {
                minFrequency = count;
            }
        }

        // Calculate and print the answer
        int ans = minFrequency * 2;
        System.out.println(ans);
    }
}