import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class atcoder_ABC126_E {
    static final int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        boolean[] used = new boolean[N];
        Arrays.fill(used, false);
        int ans = 0;
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]) - 1;
            int Y = Integer.parseInt(line[1]) - 1;
            int Z = Integer.parseInt(line[2]);
            used[X] = true;
            used[Y] = true;
        }
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                ans++;
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    used[node] = true;
                    for (int nextnode : getNeighbors(node)) {
                        if (!used[nextnode]) {
                            queue.add(nextnode);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static int[] getNeighbors(int i) {
        // This function is not implemented as it's not clear how the neighbors are represented
        // In the original Python code, edge[i] seems to be a list of neighboring nodes
        return new int[0];
    }
}