import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class codeforces_621_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list elements
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                lst.add(scanner.nextInt());
            }
        }
        scanner.close();

        // Sort the list (Python's sort() followed by reverse() results in descending order)
        Collections.sort(lst);
        // Note: We don't need to physically reverse the list if we iterate backwards later.

        // Count odd numbers (od)
        int od = 0;
        for (int x : lst) {
            if ((x & 1) != 0) {
                od++;
            }
        }

        // Calculate the sum
        long sum = 0;
        boolean ok = false; // Corresponds to Python's ok = 0
        
        // The Python loop iterates over the reversed list, meaning it processes elements from largest to smallest.
        // Since we sorted ascending, we iterate from n-1 down to 0.
        for (int i = n - 1; i >= 0; i--) {
            int current = lst.get(i);

            if (current % 2 == 0) {
                sum += current;
            } else {
                // Odd number logic
                if (ok || od > 1) {
                    sum += current;
                    od--;
                    ok = !ok;
                }
            }
        }

        System.out.println(sum);
    }
}