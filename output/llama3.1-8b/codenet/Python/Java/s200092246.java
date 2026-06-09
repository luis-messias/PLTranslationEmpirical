import java.util.Scanner;

public class s200092246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] ans = new int[2];

        for (int i = 1; i <= N; i++) {
            if (sum(i) < N) {
                continue;
            } else {
                ans[0] = i - 1;
                ans[1] = sum(i) - N;
                break;
            }
        }

        for (int i = ans[0] + 1; i <= N; i++) {
            if (i != ans[1]) {
                System.out.println(i);
            }
        }
    }

    public static int sum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}