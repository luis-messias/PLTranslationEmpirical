import java.util.Scanner;

public class s764356857 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int min = B * 10;
        int max = (B + 1) * 10 - 1;

        int ans = -1;
        for (int i = min; i <= max; i++) {
            if ((int) (i * 0.08) == A) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}