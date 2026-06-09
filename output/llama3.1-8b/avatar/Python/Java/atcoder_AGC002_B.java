import java.util.*;
import java.io.*;

public class atcoder_AGC002_B {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] balls = new int[N][2];
        for (int i = 0; i < N; i++) {
            balls[i][1] = 1;
        }
        balls[0][0] = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (balls[x][0] >= 1 && balls[y][0] >= 1) {
                balls[x][0]--;
                balls[y][0]++;
            } else if (balls[x][0] == 0) {
                balls[x][1]--;
                balls[y][0]++;
            } else {
                balls[x][0]--;
                balls[y][1]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i][1] > 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}