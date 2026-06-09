import java.util.Scanner;

public class s048491063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N, M, Q;
        N = scanner.nextInt();
        M = scanner.nextInt();
        Q = scanner.nextInt();

        int[][] train = new int[N][N];
        for (int i = 0; i < M; i++) {
            int l, r;
            l = scanner.nextInt() - 1;
            r = scanner.nextInt() - 1;
            train[l][r]++;
        }

        int[][] accum = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            accum[0][i] = 0;
            int v = 0;
            for (int j = 0; j < N; j++) {
                v += train[i][j];
                accum[0][j + 1] = accum[0][j] + v;
            }
        }

        for (int i = 1; i <= N; i++) {
            int[] temp = new int[N + 1];
            v = 0;
            for (int j = 0; j < N; j++) {
                v += train[i - 1][j];
                temp[j + 1] = accum[i - 1][j] + v;
            }
            System.arraycopy(temp, 0, accum[i], 0, N + 1);
        }

        for (int i = 0; i < Q; i++) {
            int p, q;
            p = scanner.nextInt() - 1;
            q = scanner.nextInt() - 1;
            v = accum[q][q] - accum[p][q] - accum[q][p] + accum[p][p];
            System.out.println(v);
        }
    }
}