import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_276_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input string
        String input = scanner.nextLine();
        scanner.close();

        // 1. Frequency counting
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // 2. Checking the condition
        boolean x = true;
        int cnt = 0;

        // Iterate over the values (frequencies)
        for (int value : frequencyMap.values()) {
            if (value % 2 != 0) { // Odd frequency found
                if (cnt < 1) {
                    cnt += 1;
                } else {
                    // This is the second or subsequent odd frequency
                    x = false;
                    break;
                }
            }
        }

        // 3. Output logic
        if (x) {
            System.out.println("First");
        } else {
            // x is false (2 or more odd frequencies)
            if (input.length() % 2 == 0) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}