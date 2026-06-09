import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC148_F {

    static int N, TA, AO;
    static List<List<Integer>> G;
    static int[] taDist;
    static int[] aoDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N, TA, AO
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TA = Integer.parseInt(st.nextToken());
        AO = Integer.parseInt(st.nextToken());

        // Adjust to 0-based indexing
        TA--;
        AO--;

        // Initialize graph
        G = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer stEdge = new StringTokenizer(line);
            int a = Integer.parseInt(stEdge.nextToken());
            int b = Integer.parseInt(stEdge.nextToken());
            
            // Add undirected edge (a-1, b-1)
            G.get(a - 1).add(b - 1);
            G.get(b - 1).add(a - 1);
        }

        // Initialize distance arrays
        taDist = new int[N];
        aoDist = new int[N];
        
        for (int i = 0; i < N; i++) {
            taDist[i] = -1; // Use -1 to represent None/unvisited
            aoDist[i] = -1;
        }

        // DFS for TA
        taDist[TA] = 0;
        dfs(TA, 0, taDist, G);

        // DFS for AO
        aoDist[AO] = 0;
        dfs(AO, 0, aoDist, G);

        // Calculate result
        int res = -1; // Initialize to a value that will be overwritten
        
        for (int i = 0; i < N; i++) {
            // Check if both distances are reachable (not -1)
            if (taDist[i] != -1 && aoDist[i] != -1) {
                if (taDist[i] <= aoDist[i]) {
                    res = Math.max(res, aoDist[i]);
                }
            }
        }
        
        // The Python code implicitly assumes a valid result exists based on the structure.
        // If no such node exists, res remains -1. If the problem guarantees a solution, 
        // we proceed. Since the Python code uses max(res, ao_dist[i]) and initializes res=0, 
        // and then prints res - 1, we must ensure res is initialized correctly based on the logic.
        // If we initialize res =
