import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class s124725275 {

    static int H, W;
    static int si, sj, ti, tj;
    static int[][] S;

    // Helper class for coordinates and cost
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
        
        // 1. Read H and W
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 2. Read Start Coordinates
        String startLine = br.readLine();
        if (startLine == null) return;
        String[] startParts = startLine.trim().split("\\s+");
        if (startParts.length < 2) return;
        
        try {
            int startR = Integer.parseInt(startParts[0]);
            int startC = Integer.parseInt(startParts[1]);

            // 3. Read Target Coordinates
            String targetLine = br.readLine();
            if (targetLine == null) return;
            String[] targetParts = targetLine.trim().split("\\s+");
            if (targetParts.length < 2) return;
            
            int targetR = Integer.parseInt(targetParts[0]);
            int targetC = Integer.parseInt(targetParts[1]);

            // 4. Read Map Data
            String mapLine = br.readLine();
            if (mapLine == null) return;
            String[] mapParts = mapLine.trim().split("\\s+");
            if (mapParts.length < 1) return;
            
            // The problem description implies the map is given as a single line of space-separated characters.
            // We assume the map is given as a single string or array of characters representing the grid.
            // Since the input format is ambiguous, we assume the map is provided as a single string of characters
            // that needs to be parsed into a 2D array, but based on the provided structure, 
            // we will assume the map is provided as a single string of characters representing the grid row.
            
            // If the map is provided as a single string of characters:
            String mapString = mapLine.replaceAll("\\s+", "");
            char[][] map = new char[1][mapString.length()];
            for (int i = 0; i < mapString.length(); i++) {
                map[0][i] = mapString.charAt(i);
            }
            
            // --- BFS Logic ---
            
            // Distance array initialized to -1 (unvisited)
            int[][] dist = new int[1][mapString.length()];
            for (int i = 0; i < 1; i++) {
                Arrays.fill(dist[i], -1);
            }

            Queue<int[]> queue = new LinkedList<>();
            
            // Start BFS
            queue.offer(new int[]{startR, startC});
            dist[0][startC] = 0;

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            while (!queue.isEmpty()) {
