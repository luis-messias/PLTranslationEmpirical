import java.util.Scanner;

public class atcoder_ABC174_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        long t = 0;
        for (int i = 1; i <= k; i++) {
            t = (t * 10 + 7) % k;
            if (t == 0) {
                System.out.println(i);
                break;
            }
        }
        if (i > k) {
            System.out.println(-1);
        }
    }
}
