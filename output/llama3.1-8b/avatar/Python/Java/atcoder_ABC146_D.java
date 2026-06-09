import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ABC146_D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }
        Map<String, Integer> E = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            G.get(a).add(b);
            G.get(b).add(a);
            E.put((a + "," + b), 0);
        }
        System.out.println(bfs(0, N, G, E));
        for (int value : E.values()) {
            System.out.println(value);
        }
    }

    public static int bfs(int v, int N, List<List<Integer>> G, Map<String, Integer> E) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        int K = -1;
        int[] node2color = new int[N];
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            int color = 0;
            for (int nex : G.get(q)) {
                if (visited[nex]) continue;
                visited[nex] = true;
                color++;
                if (color == node2color[q]) color++;
                node2color[nex] = color;
                E.put(minmax(q, nex), color);
                queue.add(nex);
            }
            K = Math.max(K, color);
        }
        return K;
    }

    public static String minmax(int a, int b) {
        if (a <= b) return a + "," + b;
        else return b + "," + a;
    }
}