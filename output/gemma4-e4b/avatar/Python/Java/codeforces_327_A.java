import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_327_A {

    /**
     * Finds all indices where the character 'ch' appears in the string 's'.
     * @param s The input string.
     * @param ch The character to search for.
     * @return A list of indices.
     */
    public static List<Integer> find(String s, char ch) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read S
        String s = scanner.nextLine();

        // Check if '0' is present
        if (!s.contains("0")) {
            System.out.println(n - 1);
        } else {
            List<Integer> indices = find(s, '0');

            if (indices.size() == 1) {
                System.out.println(n);
            } else {
                int maximum = 0;
                
                // Iterate over all combinations of two distinct indices (i, j) from the indices list
                for (int i = 0; i < indices.size(); i++) {
                    for (int j = i + 1; j < indices.size(); j++) {
                        
                        // x[0] corresponds to indices.get(i)
                        // x[1] corresponds to indices.get(j)
                        int x0 = indices.get(i);
                        int x1 = indices.get(j);

                        // Python logic translation:
                        // indices.index(x[0]) is i (position in indices list)
                        // indices.index(x[1]) is j (position in indices list)
                        
                        // Term 1: 2 + 2 * (abs(i - j)) - 1
                        // Since j > i, abs(i - j) = j - i
                        int term1 = 2 + 2 * (j - i) - 1;
                        
                        // Term 2: abs(x[0] - x[1]) - 1
                        int term2 = Math.abs(x0 - x1) - 1;
                        
                        // Calculate candidate maximum
                        int candidate = term1 - term2;
                        
                        maximum = Math.max(maximum, candidate);
                    }
                }
                
                // Final result: s.count('1') + maximum
                int countOnes = 0;
                for (char c : s.toCharArray()) {
                    if (c == '1') {
                        countOnes++;
                    }
                }
                
                System.out.println(countOnes + maximum