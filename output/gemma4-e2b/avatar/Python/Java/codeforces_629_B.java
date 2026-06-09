import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeforces_629_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the first line, which is the count of subsequent lines
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());

        int N = 368;
        long[] m = new long[N];
        long[] f = new long[N];

        // Read T lines of data
        for (int i = 0; i < T; i++) {
            line = br.readLine();
            if (line == null) break;
            
            StringTokenizer st = new StringTokenizer(line);
            String x = st.nextToken();
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            // Python logic: b = int(b) + 1
            long b_val = b + 1;

            if (x.equals("M")) {
                m[(int) a] += 2;
                m[(int) b_val] -= 2;
            } else {
                f[(int) a] += 2;
                f[(int) b_val] -= 2;
            }
        }

        long a_sum = 0;
        long b_sum = 0;
        long c = 0;

        // Calculate cumulative sums and find c based on the Python logic
        for (