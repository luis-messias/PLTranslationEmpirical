import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC089_C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line.trim());

        // Read S = [input() for _ in range(N)]
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s != null) {
                S.add(s.trim());
            }
        }

        // march = ["M", "A", "R", "C", "H"]
        String[] march = {"M", "A", "R", "C", "H"};
        
        // march_lis = [0] * 5. Use long for counts to be safe, although int might suffice based on typical constraints.
        long[] marchLis = new long[5];

        // Calculate march_lis
        for (String s : S) {
            if (s.length() > 0) {
                char firstChar = Character.
