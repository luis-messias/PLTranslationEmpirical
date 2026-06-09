import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_400_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Consume the rest of the line after reading N and M
        scanner.nextLine(); 

        Set<Integer> c = new HashSet<>();

        // Read N strings
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            
            // Find indices of 'S' and 'G'
            int indexS = s.indexOf('S');
            int indexG = s.indexOf('G');
            
            // Calculate difference
            int diff = indexS - indexG;
            
            c.add(diff);
        }

        // Check if any element in the set is negative
        boolean hasNegative = false;
        for (int diff : c) {
            if (diff < 0) {
                hasNegative = true;
                break;
            }
        }

        // Print result
        if (hasNegative) {
            System.out.println(-1);
        } else {
            System.out.println(c.size());
        }
        
        scanner.close();
    }
}