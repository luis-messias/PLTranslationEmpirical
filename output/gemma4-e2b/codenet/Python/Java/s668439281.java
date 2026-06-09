import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s668439281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        // Read n lines of input
        String[] ls = new String[n];
        for (int i = 0; i < n; i++) {
            ls[i] = br.readLine();
        }

        // 1. Count frequencies (equivalent to collections.Counter)
        Map<String, Integer> counts = new HashMap<>();
        for (String s : ls) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        if (counts.isEmpty()) {
            return;
        }

        // 2. Find the maximum frequency (equivalent to c.most_common()[0][1])
        int maxCount = 0;
        for (int count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // 3. Collect elements that have the maximum frequency
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount) {
                ans.add(entry.getKey());
            }
        }

        // 4. Sort the result (equivalent to sorted(ans))
        Collections.sort(ans);

        // 5. Print the results
        for (String s : ans) {
            System.out.println(s);
        }
    }
}