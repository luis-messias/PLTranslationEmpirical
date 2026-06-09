import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC165_C {

    static int N, M, Q;
    static int[] a, b, c, d;
    static long res = 0;

    /**
     * Recursive function to explore sequences A.
     * A is the current sequence being built.
     */
    private static void rec(List<Integer> A) {
        if (A.size() == N) {
            long ans = 0;
            for (int i = 0; i < Q; i++) {
                // Check the condition: A[b[i] - 1] - A[a[i] - 1] == c[i]
                // Indices a[i] and b[i] are 1-based in the input, so we use -1 for 0-based indexing.
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read N, M, Q
        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        if (!st.hasMoreTokens()) return;
        N = Integer.parseInt(st.nextToken());
        if (!st.hasMoreTokens()) return;
        M = Integer.parseInt(st.nextToken());
        if (!st.hasMoreTokens()) return;
        Q = Integer.parseInt(st.nextToken());

        // Initialize arrays a, b, c, d
        a = new int[Q];
        b = new int[Q];
        c = new int[Q];
        d = new int[Q];

        // Read the Q sets of a, b, c, d
        for (int i = 0; i < Q; i++) {
            String lineData = br.readLine();
            if (lineData == null) break;
            st = new StringTokenizer(lineData);
            
            if (!st.hasMoreTokens()) continue;
            a[i] = Integer.parseInt(st.nextToken());
            
            if (!st.hasMoreTokens()) continue;
            b[i] = Integer.parseInt(st.nextToken());
            
            if (!st.hasMoreTokens()) continue;
            c[i] = Integer.parseInt(st.nextToken());
            
            if (!st.hasMoreTokens()) continue;
            d[i] = Integer.parseInt(st.nextToken());
        }

        // Start the recursion with an empty list
        rec(new ArrayList<>());
        System.out.println(res);
    }
}
