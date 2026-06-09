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
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
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

        // Calculate distances using DFS
        taDist[TA] = 0;
        aoDist[AO] = 0;

        // DFS for TA
        taDfs(TA);

        // DFS for AO
        aoD