import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class atcoder_ABC146_D {

    // Helper class/structure to represent the edge key (min, max) for the map
    static class EdgeKey {
        int u, v;

        public EdgeKey(int a, int b) {
            this.u = Math.min(a, b);
            this.v = Math.max(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EdgeKey edgeKey = (EdgeKey) o;
            return u == edgeKey.u && v == edgeKey.v;
        }

        @Override
        public int hashCode() {
            // Simple hash code for pair (u, v)
            return 31 * u + v;
        }
    }

    static int bfs(int v, int N, Deque<Integer>[] G, Map<EdgeKey, Integer> E) {
        // visited[i] = 0 (unvisited), 1 (visited)
        int[] visited = new int[N];
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        // nodeColor stores the assigned color/label for each node. Initial
