import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC109_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Read the list l
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                l.add(scanner.nextLine());
            }
        }
        scanner.close();

        // s = defaultdict(lambda: 0) -> Frequency map
        Map<String, Integer> s = new HashMap<>();
        for (String v : l) {
            s.put(v, s.getOrDefault(v, 0) + 1);
        }

        // f = 'Yes'
        String f = "Yes";
        
        // i = -1
        int i = -1;

        // Iterate through l
        for (String v : l) {
            // s[v] += 1 (This part is redundant if we pre-calculated counts, but we follow the Python structure)
            // Since we already calculated counts in the setup phase, we only need to check the conditions based on the list l.
            
            // Check for duplicates (s[v] >= 2)
            if (s.get(v) >= 2) {
                f = "No";
            }

            // Check adjacency condition: if i != -1 and l[i][-1] != v[0]
            if (i != -1) {
                String prevV = l.get