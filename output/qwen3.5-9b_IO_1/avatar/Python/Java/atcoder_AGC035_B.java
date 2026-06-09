import java.util.*;

public class atcoder_AGC035_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        Set<Integer>[] edges = new HashSet[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new HashSet<>();
        }
        
        int[] degs = new int[N];
        int[] parity = new int[N];
        boolean[] flag = new boolean[N];
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a - 1].add(b - 1);
            edges[b - 1].add(a - 1);
            degs[a - 1]++;
            degs[b - 1]++;
        }
        
        if (M % 2 != 0) {
            System.out.println(-1);
            return;
        }
        
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < N; i++) {
            Q.offer(new int[]{degs[i], i});
        }
        
        while (!Q.isEmpty()) {
            int[] current = Q.poll();
            int degree = current[0];
            int u = current[1];
            
            if (flag[u]) {
                continue;
            }
            flag[u] = true;
            
            for (int v : edges[u]) {
                edges[v].remove(u);
                if (parity[u] != 0 && v == 0) {
                    System.out.println(u + 1 + " " + v + 1);
                    parity[u] = 1 - parity[u];
                } else {
                    System.out.println(v + 1 + " " + u + 1);
                    parity[v] = 1 - parity[v];
                }
                degs[v]--;
                Q.offer(new int[]{degs[v], v});
            }
        }
    }
}
