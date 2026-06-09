import java.util.*;
import java.io.*;

public class atcoder_ABC166_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] h = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            h[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> hp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hp.put(i, h[i]);
        }
        
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            path.get(a).add(b);
            path.get(b).add(a);
        }
        
        int c = 0;
        for (int i = 1; i <= n; i++) {
            boolean f = false;
            for (int j : path.get(i)) {
                if (hp.get(i) <= hp.get(j)) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                c++;
            }
        }
        
        System.out.println(c);
    }
}
