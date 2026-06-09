import java.util.*;

public class s908812767 {
    static Map<Integer, List<int[]>> V = new HashMap<>();
    static Map<Integer, Integer> color = new HashMap<>();
    
    static boolean dfs(int i) {
        for (int[] edge : V.getOrDefault(i, new ArrayList<>())) {
            int v = edge[0];
            int w = edge[1];
            if (w % 2 == 0) {
                if (color.getOrDefault(v, -1) == -1) {
                    color.put(v, color.get(i));
                } else if (color.get(v) == color.get(i)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (color.getOrDefault(v, -1) == -1) {
                    color.put(v, color.get(i) == 0 ? 1 : 0);
                } else if (color.get(v) == color.get(i)) {
                    return false;
                } else {
                    continue;
                }
            }
            if (!dfs(v)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            
            if (!V.containsKey(u)) {
                V.put(u, new ArrayList<>());
            }
            V.get(u).add(new int[]{v, w});
            
            if (!V.containsKey(v)) {
                V.put(v, new ArrayList<>());
            }
            V.get(v).add(new int[]{u, w});
        }
        
        for (int i = 1; i <= n; i++) {
            color.put(i, -1);
        }
        
        for (int i = 1; i <= n; i++) {
            if (color.get(i) == -1) {
                color.put(i, 0);
                if (!dfs(i)) {
                    System.out.println("No");
                    return;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.println(color.get(i));
        }
    }
}
