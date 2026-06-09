import java.util.Scanner;

public class atcoder_AGC002_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] balls = new int[N][2];
        for (int i = 0; i < N; i++) {
            balls[i][0] = 1;
            balls[i][1] = 0;
        }
        balls[0][0] = 0;
        balls[0][1] = 1;
        
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int wx = balls[x - 1][0];
            int rx = balls[x - 1][1];
            int wy = balls[y - 1][0];
            int ry = balls[y - 1][1];
            
            if (wx >= 1 && rx >= 1) {
                balls[x - 1][0] -= 1;
                balls[y - 1][1] += 1;
            } else if (wx == 0) {
                balls[x - 1][1] -= 1;
                balls[y - 1][1] += 1;
            } else {
                balls[x - 1][0] -= 1;
                balls[y - 1][0] += 1;
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
