import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class s768331281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and L from the first line
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        // L is read but unused, matching the Python logic
        // int L = scanner.nextInt(); 

        // Read the N strings
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Equivalent to .rstrip() in Python
                S.add(line.trim());
            }
        }

        // Sort the list of strings
        Collections.sort(S);

        // Join the sorted strings
        StringBuilder result = new StringBuilder();
        for (String s : S) {
            result.append(s);
        }

        // Print the result
        System.out.println(result.toString());
    }
}