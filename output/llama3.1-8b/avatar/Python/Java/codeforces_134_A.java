import java.util.Scanner;

public class codeforces_134_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int x = 0;
        for (int i : w) {
            x += i;
        }
        int[] d = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if ((x - w[i]) / (n - 1) == w[i]) {
                d[j++] = i + 1;
            }
        }
        System.out.println(j);
        for (int i = 0; i < j; i++) {
            System.out.print(d[i] + " ");
        }
    }
}