import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class s804484425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and K
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        // Read info
        List<int[]> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int[] item = new int[2];
            item[0] = Integer.parseInt(line[0]); // t
            item[1] = Integer.parseInt(line[1]); // d
            info.add(item);
        }

        // Sort info based on the second element (d), descending
        // Comparator.comparingInt(a -> a[1]) sorts ascending, so we use Collections.reverse
        info.sort(Comparator.comparingInt(a -> a[1]));
        Collections.reverse(info);

        // selected = info[0:k]
        List<int[]> selected = info.subList(0, Math.min(k, n));
        
        // selected_only, selected_chohuku, unselected_only
        List<Integer> selectedOnly = new ArrayList<>();
        List<Integer> selectedChohuku = new ArrayList<>();
        List<Integer> unselectedOnly = new ArrayList<>();
        
        // memo tracks unique 't' values
        Map<Integer, Boolean> memo = new HashMap<>();

        // Process selected items
        for (int[] item : selected) {
            int t = item[0];
            int d = item[1];
            if (!memo.containsKey(t)) {
                memo.put(t, true);
                selectedOnly.add(d);
            } else {
                selectedChohuku.add(d);
            }
        }

        // Process unselected items (info[k:])
        for (int i = k; i < n; i++) {
            int[] item = info.get(i);
            int t = item[0];
            int d = item[1];
            
            if (!memo.containsKey(t)) {
                memo.put(t, true);
                unselectedOnly.add(d);
            }
        }

        // Initial calculations
        long sumSelect = 0;
        for (int d : selectedChohuku) {
            sumSelect += d;
        }
        for (int d : selectedOnly) {
            sumSelect += d;
        }

        int cntType = memo.size();
        long ans = (long) cntType * cntType + sumSelect;

        // Reverse unselected_only (Python's [::-1])
        Collections.reverse(unselectedOnly);

        // Iterative optimization loop
        int limit = Math.min(selectedChohuku.size(), unselectedOnly.size());
        
        for (int i = 0; i < limit; i++) {
            // 1. Increment cnt_type
            cntType++;
            
            // 2. Update sum_select
            // Add unselected_only[-1]
            sumSelect += unselectedOnly.get(unselectedOnly.size() - 1);
            // Subtract selected_chohuku[-1]
            sumSelect -= selectedChohuku.get(selectedChohuku.size() - 1);
            
            // 3. Pop elements
            unselectedOnly.remove(unselectedOnly.size() - 1);
            selectedChohuku.remove(selectedChohuku.size() - 1);
            
            // 4. Calculate and update ans
            long tmp = (long) cntType * cntType + sumSelect;
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}
