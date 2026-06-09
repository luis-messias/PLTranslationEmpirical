import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_268_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after n

        List<List<String>> q = new ArrayList<>();

        // Read n lines of input and split them
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line by whitespace
                String[] parts = line.trim().split("\\s+");
                List<String> a = new ArrayList<>();
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        a.add(part);
                    }
                }
                q.add(a);
            }
        }

        int count = 0;
        int qSize = q.size();

        // Perform the comparison logic
        for (int jIndex = 0; jIndex < qSize; jIndex++) {
            List<String> j = q.get(jIndex);
            for (int kIndex = 0; kIndex < qSize; kIndex++) {
                List<String> k = q.get(kIndex);

                // if k == j: continue
                if (jIndex == kIndex) {
                    continue;
                }

                // elif j[0] == k[len(k) - 1]: count += 1
                // Check if j is not empty and k is not empty before accessing indices
                if (!j.isEmpty() && !k.isEmpty()) {
                    String jFirst = j.get(0);
                    String kLast = k.get(k.size() - 1);

                    if (jFirst.equals(kLast)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        scanner.close();
    }
}