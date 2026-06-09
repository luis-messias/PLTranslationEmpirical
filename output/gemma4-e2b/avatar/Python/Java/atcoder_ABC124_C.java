import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC124_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line as a string
        String s = scanner.nextLine();
        int n = s.length();

        // Mimic collections.Counter for even and odd indexed characters
        Map<Character, Integer> even = new HashMap<>();
        Map<Character, Integer> odd = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                // Even index
                even.put(c, even.getOrDefault(c, 0) + 1);
            } else {
                // Odd index
                odd.put(c, odd.getOrDefault(c, 0) + 1);
            }
        }

        // Calculate the terms based on the Python expression:
        // min( len(s) - (even["0"] + odd["1"]), len(s) - (even["1"] + odd["0"]) )

        // Term 1: even["0"] + odd["1"]
        int term1 = even.getOrDefault('0', 0) + odd.getOrDefault('1', 0);

        // Term 2: even["1"] + odd["0"]
        int term2 = even.getOrDefault('1', 0) + odd.getOrDefault('0', 0);

        // Final result
        int result = Math.min(n - term1, n - term2);

        System.out.println(result);
    }
}