import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s664563518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I() equivalent: Read N
        int N = Integer.parseInt(br.readLine());

        // s and t arrays
        String[] s = new String[N];
        int[] t = new int[N];

        // Read N lines of input
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            
            // s[i] and t[i] are read from the line
            s[i] = st.nextToken();
            // The second token is read as a string and converted to int
            t[i] = Integer.parseInt(st.nextToken());
        }

        // Read X
        String X = br.readLine();

        // Find xi
        int xi = -1;
        for (int i = 0; i < N; i++) {
            if (s[i].equals(X)) {
                xi = i;
                break;
            }
        }

        // Calculate ans
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (xi < i) {
                ans += t[i];
            }
        }

        System.out.println(ans);
    }
}