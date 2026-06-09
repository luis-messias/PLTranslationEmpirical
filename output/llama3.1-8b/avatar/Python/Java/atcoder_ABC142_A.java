import java.util.Scanner;

public class atcoder_ABC142_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int t = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) != 0) {
                t++;
            }
        }
        System.out.println((double) t / n);
    }
}