import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class s411244720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and K from the first line
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);
        
        if (!st.hasMoreTokens()) return;
        int N = Integer.parseInt(st.nextToken());
        
        if (!st.hasMoreTokens()) return;
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> S = new HashSet<>();

        for (int i = 0; i < K; i++) {
            // Read d (ignored, as per Python logic)
            // d = int(input())
            br.readLine(); 

            // Read A
            // A = [int(_) for _ in input().split()]
            String lineA = br.readLine();
            if (lineA == null) break;
            
            StringTokenizer stA = new StringTokenizer(lineA);
            
            while (stA.hasMoreTokens()) {
                S.add(Integer.parseInt(stA.nextToken()));
            }
        }

        // print(N - len(S))
        System.out.println(N - S.size());
    }
}
