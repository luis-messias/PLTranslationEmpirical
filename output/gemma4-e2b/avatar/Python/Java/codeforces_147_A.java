import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class codeforces_147_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input string s
        if (!scanner.hasNextLine()) {
            return;
        }
        String s = scanner.nextLine();

        List<String> res = new ArrayList<>();
        // Define punctuation set
        Set<String> punctuation = new HashSet<>(Arrays.asList(",", ".", "!", "?"));

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));

            if (i >= 1) {
                // Check if the current character is an empty string (which is impossible for char, 
                // but we follow the Python logic structure)
                if (current.isEmpty()) {
                    if (!res.isEmpty() && !res.get(res.size() - 1).isEmpty()) {
                        res.add(current);
                    } else {
                        continue;
                    }
                } else {
                    // Current character is not empty
                    if (punctuation.contains(current)) {
                        // If the last element in res is empty
                        if (!res.isEmpty() && res.get(res.size() - 1).isEmpty()) {
                            res.remove(res.size() - 1); // Equivalent to pop()
                        }
                        res.add(current);
                        res.add(""); // Append empty string
                    } else {
                        res.add(current);
                    }
                }
            } else { // i == 0
                if (current.isEmpty()) {
                    continue;
                }
                if (punctuation.contains(current)) {
                    continue;
                } else {
                    res.add(current);
                }
            }
        }

        // Join the results
        String result = String.join("", res);
        System.out.println(result);
    }
}