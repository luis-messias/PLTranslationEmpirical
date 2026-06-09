import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class s622795537 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int n = Integer.parseInt(lineN.trim());

        // Frequency map
        Map<String, Integer> arr = new HashMap<>();

        // Read n strings and count frequencies
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s != null) {
                arr.put(s, arr.getOrDefault(s, 0) + 1);
            }
        }

        // 1. Find max_count
        int maxCount = 0;
        if (!arr.isEmpty()) {
            for (int count : arr.values()) {
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }

        // 2. Collect keys with max_count
        List<String> dic = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : arr.entrySet()) {
            if (entry.getValue() == maxCount) {
                dic.add(entry.getKey());
            }
        }

        // 3. Sort and print
        Collections.sort(dic);

        for (String s : dic) {
            System.out.println(s);
        }
    }
}