import java.util.Scanner;

public class s200092246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int ans = 0;
        boolean found = false;

        for (int i = 1; i <= N; i++) {
            if (sum(i) < N) {
                continue;
            } else {
                ans = i - 1;
                found = true;
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!found || i != ans + 1) {
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
