import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_621_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the list elements
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                lst.add(scanner.nextInt());
            } else {
                // Handle case where input might be incomplete, though usually guaranteed in these problems
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
            if ((i & 1) != 0) {
                od++;
            }
        }

        // Calculate sum
        int sum = 0;
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