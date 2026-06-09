import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC165_C {

    // Global variables to store input parameters
    static int N, M, Q;
    static int[] a, b, c, d;
    static long res = 0; // Use long for result just in case sums get large, although int might suffice based on Python context.

    /**
     * Recursive function to explore sequences A.
     * A is the current sequence being built.
     */
    private static void rec(List<Integer> A) {
        if (A.size() == N) {
            long ans = 0;
            for (int i = 0; i < Q; i++) {
                // Python: A[b[i] - 1] - A[a[i] - 1] == c[i]
                // Java uses 0-based indexing. Indices a[i] and b[i] are 1-based in the problem context.
                if (A.get(b[i] - 1) - A.get(a[i] - 1) == c[i]) {
                    ans += d[i];
                }
            }
            if (ans > res) {
                res = ans;
            }
            return;
        }

        // Determine the starting value for the next element
        int lastMax = (A.isEmpty()) ? 1 : A.get(A.size() - 1);

        // Iterate possible values for the next element (i) from last_max to M
        for (int i = lastMax; i <= M; i++) {
            // Create a new list for the recursive call (A + [i])
            List<Integer> nextA = new ArrayList<>(A);
            nextA.add(i);
            rec(nextA);
        }
    }

    public static void solve() {
        // Start the recursion with an empty list
        rec(new ArrayList<>());
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Read all tokens from stdin
        StringTokenizer st;

        // Read N, M, Q
        if ((st = new StringTokenizer(br.readLine())) == null) return;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // Initialize arrays a, b, c, d
        a = new int[Q];
        b = new int[Q];
        c = new int[Q];
        d = new int[Q];

        // Read the Q sets of a, b, c, d
        for (int i = 0; i < Q; i++) {
            if ((st = new StringTokenizer(br.readLine())) == null) return;
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt