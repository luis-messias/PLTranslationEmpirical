import java.util.Arrays;
import java.util.Scanner;

public class atcoder_AGC006_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        if (X == 1 || X == N * 2 - 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            if (X == N * 2 - 2) {
                for (int i = N - 1; i <= X + 2; i++) {
                    System.out.print(i + " ");
                }
                for (int i = 1; i < N - 1; i++) {
                    System.out.print(i + " ");
                }
            } else {
                int[] ys = new int[N * 2];
                for (int i = 0; i < N * 2; i++) {
                    if (i >= X - 1 && i <= X + 3) continue;
                    ys[i] = i;
                }
                int[] xs = Arrays.copyOfRange(ys, 0, N - 3);
                xs = Arrays.copyOf(xs, xs.length + 4);
                xs[N - 3] = X + 2;
                xs[N - 2] = X - 1;
                xs[N - 1] = X;
                xs[N] = X + 1;
                for (int i : xs) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static int[] sub(int[] x, boolean debug) {
        if (debug) {
            System.out.println("D" + Arrays.toString(x));
        }
        while (x.length > 1) {
            int[] y = new int[x.length - 2];
            for (int i = 0; i < x.length - 2; i++) {
                y[i] = Arrays.stream(Arrays.copyOfRange(x, i, i + 3)).sorted().skip(1).findFirst().getAsInt();
            }
            if (debug) {
                System.out.println("D" + Arrays.toString(y));
            }
            x = y;
        }
        return x;
    }

    public static int calc(int[] x) {
        int[] y = sub(x, false);
        if (y[0] == 2) {
            sub(x, true);
            System.out.println("=" + Arrays.toString(x));
        }
        return y[0];
    }
}