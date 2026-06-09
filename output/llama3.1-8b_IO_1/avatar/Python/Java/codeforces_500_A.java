import java.util.Scanner;

public class codeforces_500_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, t;
        try {
            n = scanner.nextInt();
            t = scanner.nextInt();

            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }

            int currentCell = 0;
            while (currentCell <= t) {
                if (currentCell >= n) {
                    break;
                }
                currentCell += s[currentCell - 1];
                if (currentCell == t) {
                    System.out.println("YES");
                    return;
                }
            }
        } finally {
            scanner.close();
        }
        System.out.println("NO");
    }
}
