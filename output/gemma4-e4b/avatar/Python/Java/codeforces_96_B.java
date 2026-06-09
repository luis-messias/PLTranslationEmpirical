import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_96_B {

    // Using a static list to mimic the global list 'l' in Python
    private static List<Long> l = new ArrayList<>();
    private static final long LIMIT = 10000000000L;

    /**
     * Generates numbers composed of 4s and 7s recursively.
     * @param number The current number being built.
     * @param four Count of 4s used.
     * @param seven Count of 7s used.
     */
    private static void gen(long number, int four, int seven) {
        if (number > LIMIT) {
            return;
        }

        // Condition check: number > 0 and four == seven
        if (number > 0 && four == seven) {
            l.add(number);
        }

        // Append 4
        // Check for potential overflow before recursion, although LIMIT handles it mostly.
        if (number * 10 + 4 <= LIMIT) {
            gen(number * 10 + 4, four + 1, seven);
        }

        // Append 7
        if (number * 10 + 7 <= LIMIT) {
            gen(number * 10 + 7, four, seven + 1);
        }
    }

    public static void main(String[] args) {
        // 1. Generate numbers
        gen(0, 0, 0);

        // 2. Sort the list
        Collections.sort(l);

        // 3. Read input N
        Scanner scanner = new Scanner(System.in);
        long n;
        if (scanner.hasNextLong()) {
            n = scanner.nextLong();
        } else {
            // Handle case where input might be missing or invalid, though typically not needed for competitive programming style translation
            return; 
        }
        scanner.close();

        // 4. Find the smallest value >= N
        long ans = -1; // Initialize answer
        
        for (long val : l) {
            if (val >= n) {
                ans = val;
                break;
            }
        }

        // 5. Print the result
        System.out.println(ans);
    }
}