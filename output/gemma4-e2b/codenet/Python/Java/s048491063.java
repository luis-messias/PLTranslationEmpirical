import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s048491063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N, M, Q
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // Initialize train matrix (N x N)
        int[][] train = new int[N][N];

        // Read M updates
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            // Adjust to 0-based indexing
            train[l - 1][r - 1]++;
        }

        // Calculate 2D prefix sums (accum)
        // accum will be (N+1) x (N+1) based on the Python logic structure
        // We use long to prevent potential overflow during summation
        long[][] accum = new long[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            long[] temp = new long[N + 1];
            long v = 0;
            for (int j = 0; j < N; j++) {
                v += train[i][j];
                // accum[-1][j+1] corresponds to accum[i][j+1] in the loop context
                // accum[-1] is the previous row (accum[i])
                temp[j + 1] = accum[i][j + 1] + v;
            }
            // Store the calculated row (which corresponds to accum[i+1])
            for (int j = 0; j <= N; j++) {
                accum[i + 1][j] = temp[j];
            }
        }

        // Process Q queries
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < Q; k++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q =