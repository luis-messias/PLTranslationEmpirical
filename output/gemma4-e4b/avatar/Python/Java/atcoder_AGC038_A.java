import java.util.Scanner;

public class atcoder_AGC038_A {
    public static void solve(int H, int W, int A, int B) {
        char[][] answer = new char[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                char c;
                
                if (i < B) {
                    if (j < A) {
                        c = '0';
                    } else {
                        c = '1';
                    }
                } else {
                    if (j < A) {
                        c = '1';
                    } else {
                        c = '0';
                    }
                }
                answer[i][j] = c;
            }
        }

        for (int i = 0; i < H; i++) {
            System.out.println(new String(answer[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            
            solve(H, W, A, B);
        }
        
        scanner.close();
    }
}