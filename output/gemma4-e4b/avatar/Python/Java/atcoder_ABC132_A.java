import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC132_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        // Use a HashMap to store character counts (equivalent to Python's Counter)
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Check if the number of unique characters (Sa) is exactly 2
        if (counts.size() != 2) {
            System.out.println("No");
            return;
        }

        // Check if every unique character appears exactly twice
        boolean allCountsAreTwo = true;
        for (int count : counts.values()) {
            if (count != 2) {
                allCountsAreTwo = false;
                break;
            }
        }

        if (allCountsAreTwo) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}