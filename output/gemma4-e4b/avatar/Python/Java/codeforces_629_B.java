import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class codeforces_629_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (T)
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;
        }
        int T = Integer.parseInt(line.trim());

        int N = 368;
        int[] m = new int[N];
        int[] f = new int[N];

        for (int i = 0; i < T; i++) {
            line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            
            if (!st.hasMoreTokens()) continue;
            char x = st.nextToken().charAt(0);
            
            if (!st.hasMoreTokens()) continue;
            int a = Integer.parseInt(st.nextToken());
            
            if (!st.hasMoreTokens()) continue;
            int b = Integer.parseInt(st.nextToken());

            // Python logic: b is incremented by 1
            b = b + 1;

            if (x == 'M') {
                m[a] += 2;
                m[b] -= 2;
            } else { // x == 'F'
                f[a] += 2;
                f[b] -= 2;
            }
        }

        int currentA = 0;
        int currentB = 0;
        int maxMin = 0;

        for (int i = 0; i < N; i++) {
            currentA += m[i];
            currentB += f[i];
            
            int currentMin = Math.min(currentA, currentB);
            if (currentMin > maxMin) {
                maxMin = currentMin;
            }
        }

        System.out.println(maxMin);
    }
}