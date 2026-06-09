import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class atcoder_ARC086_B {

    // Helper function to calculate the sign: 1 if positive, -1 if negative, 0 if zero.
    private static int mySign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int N = Integer.parseInt(lineN.trim());

        // Read array a
        int[] a = new int[N];
        if (N > 0) {
            String lineA = br.readLine();
            if (lineA != null) {
                StringTokenizer st = new StringTokenizer(lineA);
                for (int i = 0; i < N; i++) {
                    if (st.hasMoreTokens()) {
                        a[i] = Integer.parseInt(st.nextToken());
                    } else {
                        break; 
                    }
                }
            }
        }

        // Find max_val, max_sign, and max_index
        long maxVal = 0;
