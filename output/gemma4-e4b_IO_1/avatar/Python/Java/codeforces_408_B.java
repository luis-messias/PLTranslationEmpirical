import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;

public class codeforces_408_B {

    /**
     * Counts the frequency of each character in the given string.
     * @param s The input string.
     * @return A map containing character counts.
     */
    private static Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    /**
     * Executes the core logic: calculates the maximum number of common characters
     * between two input strings, limited by minimum frequency.
     */
    public static void solution() {
        // Use Scanner to read input from System.in
        Scanner scanner = new Scanner(System.in);
        
        // Read the first line (bought_count)
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String line1 = scanner.nextLine();
        Map<Character, Integer> boughtCount = countChars(line1);

        // Read the second line (made_cout)
        String line2 = "";
        if (scanner.hasNextLine()) {
            line2 = scanner.nextLine();
        }
        
        Map<Character, Integer> madeCount = countChars(line2);

        int res = 0;

        // Iterate through characters present in madeCount
        for (Map.Entry<Character, Integer> entry : madeCount.entrySet()) {
            char color = entry.getKey();
            int countMade = entry.getValue();

            // Check if the color exists in boughtCount
            if (!boughtCount.containsKey(color)) {
                System.out.println(-1);
                scanner.close();
                return;
            }

            int countBought = boughtCount.get(color);
            
            // Calculate min(bought_count[color], made_cout[color])
            res += Math.min(countBought, countMade);
        }

        System.out.println(res);
        
        scanner.close();
    }

    public static void main(String[] args) {
        // The original Python code runs the solution once (t=1).
        solution();
    }
}
