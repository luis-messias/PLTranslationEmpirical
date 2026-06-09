import java.util.Scanner;

public class codeforces_203_B {
    public static void solveCase() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] count = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = false;
            }
        }

        int ans = -1;
        for (int k = 0; k < m; k++) {
            input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;

            boolean found = false;
            for (int i = Math.max(0, x-2); i <= Math.min(n-1, x+2); i++) {
                for (int j = Math.max(0, y-2); j <= Math.min(n-1, y+2); j++) {
                    if (i >= 0 && i < n && j >= 0 && j < n) {
                        count[i][j] = true;
                        if (count[i][j]) {
                            found = true;
                        }
                    }
                }
            }

            if (!found) {
                ans = k + 1;
                break;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        solveCase();
    }
}
