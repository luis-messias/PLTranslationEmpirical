import java.util.Scanner;

public class codeforces_356_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] out = new int[n];
        int[] comp = new int[n];

        for (int i = 0; i < n; i++) {
            comp[i] = i + 2;
        }

        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);

            int t = l;
            while (t <= r) {
                int nextVal = comp[t - 1];
                if (out[t - 1] == 0 && t != x) {
                    out[t - 1] = x;
                }
                comp[t - 1] = r + 1;
                if (t < x) {
                    comp[t - 1] = x;
                }
                t = nextVal;
            }
        }

        for (int i : out) {
            System.out.print(i + " ");
        }
    }
}