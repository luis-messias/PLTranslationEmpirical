import java.util.Scanner;

public class s708549466 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and x
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int x = scanner.nextInt();

        // Read array a
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            a[i] = scanner.nextInt();
        }

        long cnt = 0;

        for (int i = 1; i < N; i++) {
            int tmp = a[i - 1] + a[i];
            if (tmp > x) {
                int reduction = tmp - x;
                if (reduction > a[i]) {
                    // a[i - 1] = tmp - a[i] - x
                    a[i - 1] = tmp - a[i] - x;
                    a[i] = 0;
                } else {
                    // a[i] = a[i] - (tmp - x)
                    a[i] = a[i] - reduction;
                }
                cnt += reduction;
            }
        }

        System.out.println(cnt);
        scanner.close();
    }
}