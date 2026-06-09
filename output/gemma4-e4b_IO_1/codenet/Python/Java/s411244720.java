import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class s411244720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N and K (First line)
        String lineNK = br.readLine();
        if (lineNK == null) return;
        StringTokenizer stNK = new StringTokenizer(lineNK);
        int N = Integer.parseInt(stNK.nextToken());
        int K = Integer.parseInt(stNK.nextToken());

        Set<Integer> S = new HashSet<>();

        // 2. Loop K times
        for (int i = 0; i < K; i++) {
            // Read d (single integer, unused in logic but must be consumed)
            String lineD = br.readLine();
            if (lineD == null) break;
            // We consume the line for d, but don't need the value.

            // Read A (list of elements)
            String lineA = br.readLine();
            if (lineA == null) break;
            
            StringTokenizer stA = new StringTokenizer(lineA);
            while (stA.hasMoreTokens()) {
                int element = Integer.parseInt(stA.nextToken());
                S.add(element);
            }
        }

        // 3. Print N - len(S)
        System.out.println(N - S.size());
    }
}
