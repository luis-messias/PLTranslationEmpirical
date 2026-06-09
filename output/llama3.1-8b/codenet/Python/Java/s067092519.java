import java.util.Scanner;

public class s067092519 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][][] m = new int[10][3][10];

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            int b = Integer.parseInt(input[0]);
            int f = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);
            int v = Integer.parseInt(input[3]);

            m[b - 1][f - 1][r - 1] += v;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                StringBuilder line = new StringBuilder();
                for (int k = 0; k < 10; k++) {
                    line.append(" ").append(m[i][j][k]);
                }
                System.out.println(line.toString());
            }
            if (i < 3) {
                System.out.println(new String(new char[20]).replace("\0", "#"));
            }
        }
    }
}