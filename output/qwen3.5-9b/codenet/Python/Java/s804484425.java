import java.util.*;

public class s804484425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        List<int[]> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int d = sc.nextInt();
            info.add(new int[]{t, d});
        }
        
        // Sort by damage in descending order
        info.sort((a, b) -> Integer.compare(b[1], a[1]));
        
        List<int[]> selected = info.subList(0, k);
        
        List<Integer> selected_only = new ArrayList<>();
        List<Integer> selected_chohuku = new ArrayList<>();
        List<Integer> unselected_only = new ArrayList<>();
        Map<Integer, Boolean> memo = new HashMap<>();
        
        for (int[] item : selected) {
            int t = item[0];
            int d = item[1];
            if (!memo.containsKey(t)) {
                memo.put(t, true);
                selected_only.add(d);
            } else {
                selected_chohuku.add(d);
            }
        }
        
        int cnt_type = memo.size();
        
        for (int i = k; i < n; i++) {
            int t = info.get(i)[0];
            int d = info.get(i)[1];
            if (!memo.containsKey(t)) {
                memo.put(t, true);
                unselected_only.add(d);
            }
        }
        
        int sum_select = 0;
        for (int d : selected_chohuku) {
            sum_select += d;
        }
        for (int d : selected_only) {
            sum_select += d;
        }
        
        int ans = cnt_type * cnt_type + sum_select;
        
        Collections.reverse(unselected_only);
        
        int minLen = Math.min(selected_chohuku.size(), unselected_only.size());
        for (int i = 0; i < minLen; i++) {
            cnt_type++;
            sum_select += unselected_only.get(unselected_only.size() - 1 - i);
            sum_select -= selected_chohuku.get(selected_chohuku.size() - 1 - i);
            unselected_only.remove(unselected_only.size() - 1);
            selected_chohuku.remove(selected_chohuku.size() - 1);
            int tmp = cnt_type * cnt_type + sum_select;
            ans = Math.max(ans, tmp);
        }
        
        System.out.println(ans);
    }
}