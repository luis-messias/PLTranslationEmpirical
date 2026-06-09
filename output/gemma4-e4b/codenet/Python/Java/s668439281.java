import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class s668439281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int n = Integer.parseInt(lineN);
        
        // Read list of strings
        String[] ls = new String[n];
        for (int i = 0; i < n; i++) {
            ls[i] = br.readLine();
        }
        
        // 1. Counting (Counter equivalent)
        Map<String, Integer> counts = new HashMap<>();
        for (String s : ls) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        
        // 2. Finding Max Count
        int maxCount = 0;
        for (int count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        // 3. Collecting Results
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount) {
                ans.add(entry.getKey());
            }
        }
        
        // 4. Sorting and Output
        Collections.sort(ans);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}