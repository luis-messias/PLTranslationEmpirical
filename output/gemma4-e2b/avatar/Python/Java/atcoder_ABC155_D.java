import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class atcoder_ABC155_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and K
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        // Read array A
        st = new StringTokenizer(br.readLine());
        long[] A = new long[(int) N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        
        // Sort A
        Arrays.sort(A);
        
        // Binary search bounds for x
        long ll = -1000000000000000000L - 1; // -10^18 - 1
        long rr = 1000000000000000000L + 1;  // 10^18 + 1
        
        while (ll + 1 < rr) {
            long x = (ll + rr) / 2