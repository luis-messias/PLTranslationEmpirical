import java.util.*;

public class s668439281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        Map<String, Integer> c = new HashMap<>();
        List<String> ls = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            ls.add(s);
            c.put(s, c.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            count = Math.max(count, entry.getValue());
        }
        
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            if (entry.getValue() == count) {
                ans.add(entry.getKey());
            }
        }
        
        Collections.sort(ans);
        
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
