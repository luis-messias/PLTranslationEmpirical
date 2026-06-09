import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class codeforces_131_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N (first line) - we read it but don't strictly need it for the calculation logic based on the Python code structure.
        // String line1 = br.readLine(); // N is read but ignored in the logic below.

        // Read the numbers (second line)
        String line2 = br.readLine();
        if (line2 == null || line2.isEmpty()) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(line2);
        Map<Integer, Integer> w = new HashMap<>();

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            w.put(num, w.getOrDefault(num, 0) + 1);
        }

        long c = 0;

        for (Map.Entry<Integer, Integer> entry : w.entrySet()) {
            int i = entry.getKey();
            int count_i = entry.getValue();

            if (i == 0) {
                // c += w[i] * (w[i] - 1)
                c += (long) count_i * (count_i - 1);
            } else {
                // Check for the pair (i, -i)
                if (w.containsKey(-i)) {
                    // c += w[i] * w[-i]
                    // We only need to count pairs once. Since we iterate over all i, 
                    // we only count if i > -i (i.e., i > 0) or handle the symmetry carefully.
                    // The Python code iterates over all keys i. If i=1, it counts w[1]*w[-1]. If i=-1, it counts w[-1]*w[1].
                    // This means the total sum counts each pair {i, -i} twice.
                    // We rely on the final division by 2 to correct this.
                    c += (long) count_i * w.get(-i);
                }
            }
        }

        // The Python code calculates c and then prints c // 2.
        // Since the loop counts (i, -i) and (-i, i) separately, we divide by 2.
        System.out.println(c / 2);
    }
}
