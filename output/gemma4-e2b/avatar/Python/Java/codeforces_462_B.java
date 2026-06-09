import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class codeforces_462_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k from the first line
        // The Python code reads n and k from input().split()
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        // Read s from the second line
        String s = scanner.next();

        // 1. Frequency counting
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        // 2. Sort counts in reverse order (descending)
        // Java's Arrays.sort sorts ascendingly, so we use Collections.reverseOrder() or reverse manually.
        // Since we are sorting an array of primitives, we can use a custom comparator or convert to Integer array.
        // Let's use a simple manual sort or convert to Integer array for easy reverse sorting.
        
        Integer[] countObj = new Integer[26];
        for (int i = 0; i < 26; i++) {
            countObj[i] = count[i];
        }
        Arrays.sort(countObj, Collections.reverseOrder());
        
        // Convert back to int array for easier access if needed, or work with countObj
        int[] sortedCount = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedCount[i] = countObj[i];
        }


        // 3. Calculation
        long res = 0;
        int currentK = k; // Use a mutable variable for k, initialized with the input k

        for (int i = 0; i < 26; i++) {
            int count_i = sortedCount[i];
            
            if (count_i >= currentK) {
                res += (long) currentK * currentK;
                System.out.println(res);
                // Equivalent to exit() in Python
                System.exit(0);
            } else {
                currentK -= count_i;
                res += (long) count_i * count_i;
            }
        }

        System.out.println(res);
    }
}