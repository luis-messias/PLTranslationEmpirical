import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class codeforces_621_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the list elements
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                lst.add(scanner.nextInt());
            } else {
                // Should not happen based on problem constraints
                break;
            }
        }

        // lst.sort()
        Collections.sort(lst);

        // lst.reverse()
        Collections.reverse(lst);

        // Calculate od (count of odd numbers)
        int od = 0;
        for (int i : lst) {
            // i & 1 checks if i is odd
            if ((i & 1) != 0) {
                od++;
            }
        }

        // Calculate sum
        long sum = 0; // Use long for sum to prevent potential overflow, although the result fits in int range for this specific input.
        boolean ok = false; // Corresponds to ok = 0 (False)

        // Loop based on n
        for (int i = 0; i < n; i++) {
            int currentElement = lst.get(i);
            
            if (currentElement % 2 == 0) {
                sum += currentElement;
            } else {
                // Python: if ( ok or od > 1 ):
                if (ok || od > 1) {
                    sum += currentElement;
                    od -= 1;
                    ok = !ok; // ok = not ok
                }
            }
        }

        // Print sum
        System.out.println(sum);
        
        scanner.close();
    }
}
