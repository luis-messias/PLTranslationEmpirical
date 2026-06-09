import java.util.Scanner;

public class atcoder_AGC033_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);

        int s_r = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int s_c = Integer.parseInt(scanner.nextLine().split(" ")[0]);

        String S = scanner.nextLine();
        String T = scanner.nextLine();

        boolean Judge = false;
        int[] S_L_R_U_D = new int[4];
        int[] T_L_R_U_D = new int[4];

        for (int x = 0; x < N; x++) {
            if (S.charAt(x) == 'L') {
                S_L_R_U_D[0]++;
                if (S_L_R_U_D[0] - T_L_R_U_D[1] - s_c == 0) {
                    Judge = true;
                }
            } else if (S.charAt(x) == 'R') {
                S_L_R_U_D[1]++;
                if (s_c + (S_L_R_U_D[1] - T_L_R_U_D[0]) == W + 1) {
                    Judge = true;
                }
            } else if (S.charAt(x) == 'U') {
                S_L_R_U_D[2]++;
                if (S_L_R_U_D[2] - T_L_R_U_D[3] - s_r == 0) {
                    Judge = true;
                }
            } else if (S.charAt(x) == 'D') {
                S_L_R_U_D[3]++;
                if (s_r + (S_L_R_U_D[3] - T_L_R_U_D[2]) == H + 1) {
                    Judge = true;
                }
            }

            if (T.charAt(x) == 'L') {
                if (S_L_R_U_D[1] - T_L_R_U_D[0] + s_c != 1) {
                    T_L_R_U_D[0]++;
                }
            } else if (T.charAt(x) == 'R') {
                if (s_c + (T_L_R_U_D[1] - S_L_R_U_D[0]) != W) {
                    T_L_R_U_D[1]++;
                }
            } else if (T.charAt(x) == 'U') {
                if (S_L_R_U_D[3] - T_L_R_U_D[2] + s_r != 1) {
                    T_L_R_U_D[2]++;
                }
            } else if (T.charAt(x) == 'D') {
                if (s_r + (T_L_R_U_D[3] - S_L_R_U_D[2]) != H) {
                    T_L_R_U_D[3]++;
                }
            }
        }

        if (Judge) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}