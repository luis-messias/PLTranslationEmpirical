import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class atcoder_ABC132_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String S = scanner.nextLine();

        Map<Character, Integer> c = new HashMap<>();
        Set<Character> Sa = new HashSet<>();

        // Calculate frequencies and unique characters
        for (char ch : S.toCharArray()) {
            c.put(ch, c.getOrDefault(ch, 0) + 1);
            Sa.add(ch);
        }

        // Check condition 1: Number of unique characters must be 2
        if (Sa.size() != 2) {
            System.out.println("No");
            return;
        }

        // Check condition 2: All characters must appear exactly twice
        boolean allCountsAreTwo = true;
        for (char i : Sa) {
            if (c.get(i) != 2) {
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