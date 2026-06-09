import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class codeforces_609_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // Read the list lst from the second line
        List<Integer> lstList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                lstList.add(scanner.nextInt());
            } else {
                // Handle unexpected end of input if necessary
                break;
            }
        }

        if (lstList.size() != n) {
            // Handle case where input list size is incorrect, though usually assumed correct in CP
            return;
        }
        
        int[] lst = lstList.stream().mapToInt(i -> i).toArray();

        // Step 1: Calculate frequencies (l)
        Map<Integer, Integer> l = new HashMap<>();
        for (int x : lst) {
            l.put(x, l.getOrDefault(x, 0) + 1);
        }

        // Step 2: Calculate result (res)
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            int currentElement = lst[i];
            int frequency = l.get(currentElement);
            
            if (frequency > 1) {
                // If the element appears more than once, we count contributions
                // The logic is: for the first occurrence of a duplicate, we count how many
                // remaining elements (n - i - 1) can be paired with it.
                // The Python logic was: res += n - i - l[lst[i]]
                res += (long)n - i - frequency;
                l.put(currentElement, frequency - 1);
            } else {
                // If the element appears only once (frequency == 1)
                // The Python logic was: res += n - i - 1
                res += (long)n - i - 1;
            }
        }

        System.out.println(res);
        
        scanner.close();
    }
}
