import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s804484425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and K
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        // Read info
        List<List<Integer>> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();
            row.add(Integer.parseInt(line[0])); // t
            row.add(Integer.parseInt(line[1])); // d
            info.add(row);
        }

        // Sort info based on the second element (d) in reverse order
        // info = sorted(info, key = itemgetter(1), reverse = True)
        Collections.sort(info, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                // Sort by the second element (index 1) in descending order
                return b.get(1).compareTo(a.get(1));
            }
        });

        // Select the top K elements
        List<List<Integer>> selected = info.subList(0, k);

        List<Integer> selectedOnly = new ArrayList<>();
        List<Integer> selectedChohuku = new ArrayList<>();
        List<Integer> unselectedOnly = new ArrayList<>();
        Map<Integer, Integer> memo = new HashMap<>();

        // Partition selected items
        for (List<Integer> item : selected) {
            int t = item.get(0);
            int d = item.get(1);
            if (!memo.containsKey(t)) {
                memo.put(t, 1);
                selectedOnly.add(d);
            } else {
                selectedChohuku.add(d);
            }
        }

        int cntType = memo.size();

        // Partition unselected items
        for (int i = k; i < n; i++) {
            List<Integer> item = info.get(i);
            int t = item.get(0);
            int d = item.get(1);
            if (!memo.containsKey(t)) {
                memo.put(t, 1);
                unselectedOnly.add(d);
            }
        }

        // Calculate initial sum
        long sumSelect = 0;
        for (int d : selectedChohuku) {
            sumSelect += d;
        }
        for (int d : selectedOnly) {
            sumSelect += d;
        }

        long ans = (long) cntType * cntType + sumSelect;

        // Reverse unselected_only
        Collections.reverse(unselectedOnly);

        // Optimization loop
        int limit = Math.min(selectedChohuku.size(), unselectedOnly.size());

        for (int i = 0; i < limit; i++) {
            // The Python code uses list indexing and deletion which is tricky in Java.
            // We need to manage the lists carefully.
            
            // The Python code uses unselected_only[-1] and selected_chohuku[-