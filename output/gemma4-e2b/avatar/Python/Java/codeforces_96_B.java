import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_96_B {

    private static List<Long> l = new ArrayList<>();
    private static long limit = 10000000000L;

    // Recursive generation function
    public static void gen(long number, int four, int seven) {
        if (number > limit) {
            return;
        }

        // Condition: number > 0 and four == seven
        if (number > 0 && four == seven) {
            l.add(number);
        }

        // Recursive calls
        gen(number * 10 + 4, four + 1, seven);
        gen(number * 10 + 7, four, seven + 1);
    }

    public static void main(String[] args) {
        // Start generation
        gen(0, 0, 0);

        // Sort the list
        Collections.sort(l);

        // Read input
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            long ans = 0;

            // Find the smallest element >= n
            for (long val : l) {
                if (val >= n) {
                    ans = val;
                    break;
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}