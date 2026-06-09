import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class s233116196 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Adjacency list for nodes 1 to N
        List<List<Integer>> G = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.get(a).add(b);
            G.get(b).add(a);
        }

        // col[i] stores the component ID of node i. -1 means unvisited.
        int[] col = new int[N + 1];
        Arrays.fill(col, -1);

        int cnt = 0; // Component counter
        
        for (int i = 1; i <= N; i++) {
            if (col[i] < 0) {
                col[i] = cnt;
                
                // BFS setup
                Deque<Integer> que = new ArrayDeque<>();
                que.add(i);
                
                while (!que.isEmpty()) {
                    int x = que.poll();
                    
                    for (int y : G.get(x)) {
                        if (col[y] < 0) {
                            col[y] = cnt;
                            que.add(y);
                        }
                    }
                }
                cnt++;
            }
        }

        // Find cmax = max(col) for indices 1 to N
        int cmax = -1;
        for (int i = 1; i <= N; i++) {
            if (col[i] > cmax) {
                cmax = col[i];
            }
        }

        System.out.println(cmax);
    }
}