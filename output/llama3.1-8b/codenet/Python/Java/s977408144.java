import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s977408144 {
    static final int mod = 1000000007;
    static final long inf = 10000000000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        String[] S = new String[n];
        for (int i = 0; i < n; i++) {
            S[i] = br.readLine();
        }
        Arrays.sort(S);
        System.out.println(String.join("", S));
    }
}