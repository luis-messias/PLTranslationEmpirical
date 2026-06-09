import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s232279435 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N (although we primarily use s.length() for the loop boundary)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading N
        scanner.nextLine(); 
        
        // Read S
        String s = scanner.nextLine();
        
        int ans = 0;
        int len = s.length();

        // The loop runs for i from 0 up to n-1 (or len-1)
        // We iterate through all possible split points i.
        for (int i = 0; i < len; i++) {
            // Prefix: s[0...i]
            String prefixStr = s.substring(0, i + 1);
            // Suffix: s[i+1...len-1]
            String suffixStr = s.substring(i + 1);

            // 1. Get unique characters in the prefix (Set X)
            Set<Character> x = getUniqueChars(prefixStr);
            
            // 2. Get unique characters in the suffix (Set Y)
            Set<Character> y = getUniqueChars(suffixStr);

            // 3. Calculate intersection size (z)
            int z = 0;
            for (char w : x) {
                if (y.contains(w)) {
                    z++;
                }
            }

            // 4. Update maximum answer
            if (z > ans) {
                ans = z;
            }
        }

        System.out.println(ans);
        scanner.close();
    }

    /**
     * Helper function to convert a string into a set of unique characters.
     */
    private static Set<Character> getUniqueChars(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}