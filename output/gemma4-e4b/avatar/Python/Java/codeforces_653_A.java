import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_653_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (the first integer, which is unused in the logic but required for input structure)
        if (!scanner.hasNextInt()) {
            System.out.println("NO");
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        // Use a Set to store the unique elements for O(1) lookups
        Set<Integer> set = new HashSet<>();
        
        // Read all remaining integers from the input stream into the set
        while (scanner.hasNextInt()) {
            set.add(scanner.nextInt());
        }
        
        scanner.close();

        boolean found = false;
        
        // Iterate through the unique elements in the set
        for (int i : set) {
            // Check if i+1 and i+2 are also present in the set
            if (set.contains(i + 1) && set.contains(i + 2)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}