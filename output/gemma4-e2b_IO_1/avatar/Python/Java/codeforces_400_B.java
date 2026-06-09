import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class codeforces_400_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        // int m = scanner.nextInt(); // m is unused

        Set<Integer> c = new HashSet<>();
        
        // Read n subsequent lines and calculate the set c
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int indexS = s.indexOf("S");
                int indexG = s.indexOf("G");
                
                // Calculate the difference. If either is -1 (not found), the result might be negative.
                // The Python code uses s.find("S") - s.find("G").
                // If S appears before G, indexS < indexG, result is negative.
                // If S appears after G, indexS > indexG, result is positive.
                // If S or G is missing, the result involves -1.
                c.add(indexS - indexG);
            }
        }

        // Print the result: -1 if any difference is negative, otherwise the size of the set.
        boolean hasNegative = false;
        for (int val : c) {
            if (val < 0) {
                hasNegative = true;
                break;
            }
        }

        if (hasNegative) {
            System.out.println(-1);
        } else {
            System.out.println(c.size());
        }
        
        scanner.close();
    }
}
