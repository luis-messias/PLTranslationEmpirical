import java.util.Scanner;
import java.lang.Math;

public class s538657784 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double sqN = Math.sqrt(N);
        for (int i = 1; i <= sqN; i++) {
            if (N % (sqN - i + 1) == 0) {
                System.out.println((int)(N / (sqN - i + 1) + sqN - i - 2));
                break;
            }
        }
    }
}