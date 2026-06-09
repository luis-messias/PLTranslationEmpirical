import java.util.Scanner;

public class codeforces_333_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        boolean[] b = new boolean[n * 2];
        for (int i = 0; i < n * 2; i++) {
            b[i] = true;
        }
        b[0] = false;
        b[n - 1] = false;
        b[n] = false;
        b[2 * n - 1] = false;

        for (int i = 0; i < m; i++) {
            input = scanner.nextLine();
            int r = Integer.parseInt(input.split(" ")[0]) - 1;
            int c = Integer.parseInt(input.split(" ")[1]);
            b[r] = false;
            b[n + c - 1] = false;
        }

        if (n % 2 != 0 && b[n / 2] && b[n + n / 2]) {
            b[n / 2] = false;
        }

        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            if (!b[i]) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}