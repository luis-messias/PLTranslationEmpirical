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
                        // Handle case where input might be malformed or incomplete
                        break; 
                    }
                }
            }
        }

        // Find max_val, max_sign, and max_index
        long maxVal = 0;
        int maxSign = 0;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            long currentAbs = Math.abs((long) a[i]);
            if (currentAbs > maxVal) {
                maxVal = currentAbs;
                maxSign = mySign(a[i]);
                maxIndex = i;
            }
        }

        // Output logic
        StringBuilder sb = new StringBuilder();

        if (maxSign == 0) {
            sb.append(0).append("\n");
        } else {
            sb.append(2L * N - 1).append("\n");

            // 1. Connect max element to all others
            for (int i = 0; i < N; i++) {
                // Indices are 1-based
                sb.append(maxIndex + 1).append(" ").append(i + 1).append("\n");
            }

            if (maxSign == 1) {
                // Case max_sign == 1: Connect adjacent elements (1-2, 2-3, ..., (N-1)-N)
                for (int i = 0; i < N - 1; i++) {
                    // i+1 connects to i+2
                    sb.append(i + 1).append(" ").append(i + 2).append("\n");
                }
            } else { // maxSign == -1
                // Case max_sign == -1: Connect adjacent elements backwards (2-1, 3-2, ..., N-(N-1))
                for (int i = 1; i < N; i++) {
                    // i+1 connects to i
                    sb.append(i + 1).append(" ").append(i).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}