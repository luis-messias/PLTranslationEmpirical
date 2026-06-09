import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class s124725275 {

    static int H, W;
    static int si, sj, ti, tj;
    static int[][] S;

    // Helper class/record for coordinates and cost
    static class State {
        int cost;
        int r;
        int c;

        public State(int cost, int r, int c) {
            this.cost = cost;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. Read H and W
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 2. Read start coordinates (si, sj)
        st = new StringTokenizer(br.readLine());
        si = Integer.parseInt(st.nextToken());
        sj = Integer.parseInt(st.nextToken());

        // 3. Read target coordinates (ti, tj)
        st = new StringTokenizer(br.readLine());
        ti = Integer.parseInt(st.nextToken());
        tj = Integer.parseInt(st.nextToken());

        // 4. Read the map S
        S = readMapAs(H, br);

        // 5. Run 0-1 BFS
        int[][] D = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(D[i], -1);
        }

        // Deque for 0-1 BFS: cost 0 items added to front, cost 1 items added to back
        Deque<State> deque = new ArrayDeque<>();
        deque.addFirst(new State(0, si, sj));
        D[si][sj] = 0;

        // Directions for product([-2, -1, 0, 1, 2], repeat=2)
        int[] diffs = {-2, -1, 0, 1, 2};

        while (!deque.isEmpty()) {
            State current = deque.removeFirst();
            int c = current.cost;
            int i = current.r;
            int j = current.c;

            // Iterate over all combinations of di and dj
            for (int di : diffs) {
                for (int dj : diffs) {
                    if (di == 0 && dj == 0) continue;

                    int ni = i + di;
                    int nj = j + dj;

                    // Boundary and obstacle checks
                    if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                    if (D[ni][nj] != -1) continue; // Already visited
                    if (S[ni][nj] == 1) continue; // Obstacle

                    int newCost;
                    boolean isWalk = (di == 0 && Math.abs(dj) == 1) || (dj == 0 && Math.abs(di) == 1);

                    if (isWalk) {
                        newCost = c; // Cost 0
                    } else {
                        newCost = c + 1; // Cost 1 (Warp)
                    }

                    // Update distance and enqueue
                    D[ni][nj] = newCost;
                    State nextState = new State(newCost, ni, nj);

                    if (newCost == c) {
                        // Cost 0: Add to front
                        deque.addFirst(nextState);
                    } else {
                        // Cost 1: Add to back
                        deque.addLast(nextState);
                    }
                }
            }
        }

        System.out.println(D[ti][tj]);
    }

    /**
     * Reads the map from the BufferedReader, handling character replacement and padding.
     * Mimics read_map_as(H, replace={'#': 1, '.': 0}, pad=None)
     */
    private static int[][] readMapAs(int H, BufferedReader br) throws IOException {
        // Assuming no padding is needed based on the usage context (H lines of map data)
        // The Python code structure suggests reading H lines of map data.
        
        int[][] map = new int[H][W];
        String[] replace = {"#", ".", " "}; // Placeholder for replacement logic
        
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException("Failed to read map line " + i);
            }
            
            // Assuming the input line length matches W
            for (int j = 0; j < W; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    map[i][j] = 1;
                } else if (c == '.') {
                    map[i][j] = 0;