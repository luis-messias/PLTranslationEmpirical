import java.io.*;
import java.util.*;

public class atcoder_AGC014_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        boolean[] seen = new boolean[N + 1];
        seen[1] = true;
        int[] par = new int[N + 1];
        int[] child_num = new int[N + 1];
        
        while (!que.isEmpty()) {
            int v = que.poll();
            for (int u : adj.get(v)) {
                if (!seen[u]) {
                    seen[u] = true;
                    par[u] = v;
                    child_num[v]++;
                    que.add(u);
                }
            }
        }
        
        Deque<Integer> seq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (child_num[i] == 0) {
                seq.add(i);
            }
        }
        
        while (!seq.isEmpty()) {
            int c = seq.pollLast();
            seen[c] = false;
            if (seen[par[c]] == false) {
                System.out.println("First");
                return;
            }
            seen[par[c]] = false;
            int parentOfParent = par[par[c]];
            child_num[parentOfParent]--;
            if (child_num[parentOfParent] == 0) {
                seq.add(parentOfParent);
            }
        }
        
        System.out.println("Second");
    }
}
