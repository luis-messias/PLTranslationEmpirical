import java.util.Scanner;

public class atcoder_AGC033_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read H, W, N
        String[] line1 = scanner.nextLine().split(" ");
        int H = Integer.parseInt(line1[0]);
        int W = Integer.parseInt(line1[1]);
        int N = Integer.parseInt(line1[2]);

        // Read s_r, s_c
        String[] line2 = scanner.nextLine().split(" ");
        int s_r = Integer.parseInt(line2[0]);
        int s_c = Integer.parseInt(line2[1]);

        // Read S
        String S = scanner.nextLine();

        // Read T
        String T = scanner.nextLine();

        boolean Judge = false;

        // Initialize counts
        int S_L = 0, S_R = 0, S_U = 0, S_D = 0;
        int T_L = 0, T_R = 0, T_U = 0, T_D = 0;

        for (int x = 0; x < N; x++) {
            char s_char = S.charAt(x);
            char t_char = T.charAt(x);

            // Logic based on S[x]
            if (s_char == 'L') {
                S_L++;
                if (S_L - T_R - s_c == 0) {
                    Judge = true;
                }
            } else if (s_char == 'R') {
                S_R++;
                if (s_c + (S_R - T_L) == W + 1) {
                    Judge = true;
                }
            } else if (s_char == 'U') {
                S_U++;
                if (S_U - T_D - s_r == 0) {
                    Judge = true;
                }
            } else if (s_char == 'D') {
                S_D++;
                if (s_r + (S_D - T_U) == H + 1) {
                    Judge = true;
                }
            }

            // Logic based on T[x]
            if (t_char == 'L') {
                if (S_R - T_L + s_c != 1) {
                    T_L++;
                }
            } else if (t_char == 'R') {
                if (s_c + (T_R - S_L) != W) {
                    T_R++;
                }
            } else if (t_char == 'U') {
                if (S_D - T_U + s_r != 1) {
                    T_U++;
                }
            } else if (t_char == 'D') {
                if (s_r + (T_D - S_U) != H) {
                    T_D++;
                }
            }
        }

        if (Judge) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        scanner.close();
    }
}