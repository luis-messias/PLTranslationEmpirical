import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class codeforces_327_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read s
        String s = scanner.nextLine();

        // The Python code uses s = input().replace("", ""), which is just s = input().
        // We assume s is the string provided on the second line of input.

        if (!s.contains("0")) {
            System.out.println(n - 1);
        } else {
            // Equivalent to find(s, '0')
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    indices.add(i);
                }
            }

            if (indices.size() == 1) {
                System.out.println(n);
            } else {
                int maximum = 0;
                int numOnes = 0;
                for (char c : s.toCharArray()) {
                    if (c == '1') {
                        numOnes++;
                    }
                }

                // Equivalent to itertools.combinations(indices, 2)
                int numIndices = indices.size();
                for (int i = 0; i < numIndices; i++) {
                    for (int j = i + 1; j < numIndices; j++) {
                        int x0 = indices.get(i);
                        int x1 = indices.get(j);

                        // Calculate the term inside max() based on the Python logic:
                        // maximum = max(maximum, 2 + 2 * (abs(indices.index(x[0]) - indices.index(x[1])) - 1) - (abs(x[0] - x[1]) - 1))
                        
                        // Since x0 and x1 are elements of indices, indices.index(x0
