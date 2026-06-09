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
        boolean found = true;
        for (int i = 0; i < n; i++) {
            if ((x - w[i]) / (n - 1) != w[i]) {
                found = false;
                break;
            }
        }
        System.out.println(found ? "0" : "-1");
    }
}
