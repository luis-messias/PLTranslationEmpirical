import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s664563518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int N = Integer.parseInt(line.trim());

        // s stores strings, t stores integers
        String[] s = new String[N];
        int[] t = new int[N];

        // Read N pairs (s[i], t[i])
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = st.nextToken();
            // t[i] is read as a string representation of an integer
            t[i] = Integer.parseInt(st.nextToken());
        }

        // Read X
        String X = br.readLine();

        // Find xi: the index where s[i] == X
        int xi = -1;
        for (int i = 0; i < N; i++) {
            if (s[i].equals(X)) {
                xi = i;
                break;
            }
        }

        // Calculate ans: sum t[i] for all i > xi
        long ans = 0;
        if (xi != -1) {
            for (int i = xi + 1; i < N; i++) {
                ans += t[i];
            }
        }

        System.out.println(ans);
    }
}