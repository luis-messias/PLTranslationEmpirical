import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_AGC002_B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and M (MAP() equivalent)
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // balls = [ [ 1 , 0 ] for _ in range ( N ) ]
        // Initialize balls: N rows, 2 columns
        int[][] balls = new int[N][2];
        for (int i = 0; i < N; i++) {
            balls[i][0] = 1; // w_i initialized to 1
            balls[i][1] = 0; // r_i initialized to 0
        }

        // balls [ 0 ] = [ 0 , 1 ]
        balls[0][0] = 0;
        balls[0][1] = 1;

        // Process M operations
        for (int k = 0; k < M; k++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer st_op = new StringTokenizer(line);
            int x = Integer.parseInt(st_op.nextToken());
            int y = Integer.parseInt(st_op.nextToken());

            // Indices are 1-based in input, convert to 0-based
            int i = x - 1;
            int j = y - 1;

            // Retrieve current states
            int w_x = balls[i][0];
            int r_x = balls[i][1];
            int w_y = balls[j][0];
            int r_y = balls[j][1];

            // Logic translation:
            // if w_x >= 1 and r_x >= 1 :
            if (w_x >= 1 && r_x >= 1) {
                // balls [ x - 1 ] [ 0 ] -= 1  (w_x decreases)
                balls[i][0]--;
                // balls [ y - 1 ] [ 1 ] += 1  (r_y increases)
                balls[j][1]++;
            } 
            // elif w_x == 0 :
            else if (w_x == 0) {
                // balls [ x - 1 ] [ 1 ] -= 1  (r_x decreases)
                balls[i][1]--;
                // balls [ y - 1 ] [ 1 ] += 1  (