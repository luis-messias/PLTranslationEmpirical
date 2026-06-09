import java.util.Scanner;

public class codeforces_287_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] t = new int[4][4];

        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                if (input.charAt(j) == '#') {
                    t[i][j] = 1;
                } else {
                    t[i][j] = 0;
                }
            }
        }

        int black = 0;
        int white = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t[i][j] == 1) {
                    black++;
                } else {
                    white++;
                }
                if (i < 3 && t[i + 1][j] == 1) {
                    black++;
                } else {
                    white++;
                }
                if (j < 3 && t[i][j + 1] == 1) {
                    black++;
                } else {
                    white++;
                }
                if ((i < 3 && j < 3) && t[i + 1][j + 1] == 1) {
                    black++;
                } else {
                    white++;
                }

                if (black == 0 || black == 3 || white == 0 || white == 3 || white == 4 || black == 4) {
                    System.out.println("YES");
                    return;
                }
                black = 0;
                white = 0;
            }
        }
        System.out.println("NO");
    }
}