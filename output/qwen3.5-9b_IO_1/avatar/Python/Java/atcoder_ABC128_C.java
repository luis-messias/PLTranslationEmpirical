import java.util.*;

public class atcoder_ABC128_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] li = new int[m][];
        for (int i = 0; i < m; i++) {
            int[] row = new int[sc.nextInt()];
            for (int j = 0; j < row.length; j++) {
                row[j] = sc.nextInt();
            }
            li[i] = row;
        }
        
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        Set<Integer> q = new HashSet<>();
        for (int[] row : li) {
            for (int val : row) {
                q.add(val);
            }
        }
        
        Set<Integer> r = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            r.add(i);
        }
        
        Set<Integer> v = new HashSet<>(r);
        v.removeAll(q);
        
        int ans = 0;
        for (int i = 0; i <= q.size(); i++) {
            List<List<Integer>> combinations = getCombinations(q, i);
            for (List<Integer> s : combinations) {
                Set<Integer> sSet = new HashSet<>(s);
                boolean valid = true;
                for (int j = 0; j < m; j++) {
                    Set<Integer> u = new HashSet<>(Arrays.asList(li[j]));
                    int w = p[j];
                    int intersection = 0;
                    for (Integer val : sSet) {
                        if (u.contains(val)) {
                            intersection++;
                        }
                    }
                    if (intersection % 2 != w) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans += (1 << v.size());
                }
            }
        }
        
        System.out.println(ans);
    }
    
    private static List<List<Integer>> getCombinations(Set<Integer> q, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> list = new ArrayList<>(q);
        generateCombinations(list, k, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void generateCombinations(List<Integer> list, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            current.add(list.get(i));
            generateCombinations(list, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
